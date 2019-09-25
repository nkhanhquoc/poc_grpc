package com.ascend.grpc.client;

import com.ascend.proto.Greeting;
import com.ascend.proto.GreetingRequest;
import com.ascend.proto.GreetingResponse;
import com.ascend.proto.GreetingServiceGrpc;
import com.ascend.proto.SquareRootRequest;
import com.ascend.proto.SumElements;
import com.ascend.proto.SumRequest;
import com.ascend.proto.SumResponse;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;


public class ClientGrpc {
  GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;
  GreetingServiceGrpc.GreetingServiceStub asyncStub;

  public static void main(String[] args) throws SSLException {
    System.out.println("this is grpc client");
    ClientGrpc grpc = new ClientGrpc();
    grpc.run();
  }

  public void run() throws SSLException {
//    ManagedChannel channel = ManagedChannelBuilder
//        .forAddress("localhost",50051)
//        .useTransportSecurity()
//        .usePlaintext()
//        .build();
    ManagedChannel secureChannel = NettyChannelBuilder
        .forAddress("localhost",50051)
        .sslContext(GrpcSslContexts
            .forClient()
            .trustManager(new File("ssl/localhost.crt"))
            .build())
        .build();


    blockingStub = GreetingServiceGrpc
        .newBlockingStub(secureChannel);

    doUnaryCall();
//    doSumElements();
//    doStreamingServer();
//    doStreamingClient(channel);
//      doBiDiStreaming(channel);
//    doCallError();
    doCallWithDeadline();
    System.out.println("shutting down channel");
    secureChannel.shutdown();
    //channel
  }

  private void doBiDiStreaming(ManagedChannel channel){
    asyncStub = GreetingServiceGrpc.newStub(channel);
    CountDownLatch latch = new CountDownLatch(1);
    StreamObserver<GreetingRequest> requestStreamObserver = asyncStub.helloEveryone(
        new StreamObserver<GreetingResponse>() {
          @Override
          public void onNext(GreetingResponse greetingResponse) {
            System.out.println("Get response from server: "+greetingResponse.getResult());
          }

          @Override
          public void onError(Throwable throwable) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            System.out.println("server is done sending data");
            latch.countDown();
          }
        });

    Arrays.asList("Khanh", "Khanh_1", "Khanh_3").forEach(
        name -> {
          System.out.println("client send data: "+name);
          requestStreamObserver.onNext(
              GreetingRequest.newBuilder()
                  .setGreeting(Greeting.newBuilder().setGreeting(name).build())
                  .build()
          );
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
    );
    requestStreamObserver.onCompleted();

    try {
      latch.await(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doUnaryCall(){

    //Unary
    GreetingRequest req = GreetingRequest.newBuilder()
        .setGreeting(Greeting.newBuilder()
            .setGreeting("Khanh")
            .build())
        .build();

    GreetingResponse response = blockingStub.hello(req);

    System.out.println(response.getResult());
  }

  private void doSumElements(){
    SumElements elements = SumElements.newBuilder()
        .setFirstNumber(1593)
        .setSecondNumnber(345)
        .build();
    SumRequest sumRequest = SumRequest.newBuilder()
        .setSumElement(elements)
        .build();
    SumResponse sumResponse = blockingStub.sum(sumRequest);
    System.out.println("sum result: "+sumResponse.getResult());
  }

  private void doStreamingServer(){
    //Server Streaming
    GreetingRequest req = GreetingRequest.newBuilder()
        .setGreeting(Greeting.newBuilder()
            .setGreeting("Khanh")
            .build())
        .build();

    blockingStub.helloManyTimes(req)
        .forEachRemaining(helloManyTimeResponse ->{
          System.out.println(helloManyTimeResponse.getResult());
        });
  }

  private void doStreamingClient(ManagedChannel channel){
    asyncStub = GreetingServiceGrpc.newStub(channel);
    CountDownLatch latch = new CountDownLatch(1);
    StreamObserver<GreetingRequest> streamObserver = asyncStub.longHello(new StreamObserver<GreetingResponse>() {
      @Override
      public void onNext(GreetingResponse greetingResponse) {
        //response from server;
        System.out.println("receiver from server: "+greetingResponse.getResult());
      }

      @Override
      public void onError(Throwable throwable) {
        //error from server
      }

      @Override
      public void onCompleted() {
        //done from server
        System.out.println("server completed");
        latch.countDown();
      }
    });
    System.out.println("Sending message 1");
    streamObserver.onNext(
        GreetingRequest.newBuilder()
        .setGreeting(
            Greeting.newBuilder()
                .setGreeting("Khanh")
                .build())
        .build()
    );
    System.out.println("Sending message 2");
    streamObserver.onNext(
        GreetingRequest.newBuilder()
            .setGreeting(
                Greeting.newBuilder()
                    .setGreeting("Khanh_2")
                    .build())
            .build()
    );
    System.out.println("Sending message 3");
    streamObserver.onNext(
        GreetingRequest.newBuilder()
            .setGreeting(
                Greeting.newBuilder()
                    .setGreeting("Khanh_3")
                    .build())
            .build()
    );
    //tell server that client complete send data
    streamObserver.onCompleted();

    try {
      latch.await(1L, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doCallError(){
    SquareRootRequest request = SquareRootRequest.newBuilder()
        .setNumber(-1)
        .build();
    try{
      blockingStub.squareRoot(request);
    }catch (RuntimeException e){
      System.out.println("An error encountered");
      e.printStackTrace();
    }
  }

  private void doCallWithDeadline(){
    try {
      Deadline deadline = Deadline.after(7000, TimeUnit.MILLISECONDS);
      GreetingResponse response = blockingStub.withDeadline(deadline)
          .helloWithDeadline(GreetingRequest.newBuilder()
              .setGreeting(Greeting.newBuilder()
                  .setGreeting("Khanh")
                  .build())
              .build());

      System.out.println(response.getResult());
    } catch(StatusRuntimeException e){
      if(e.getStatus() == Status.DEADLINE_EXCEEDED){
        System.out.println("deadline exceeded");
      } else {
        e.printStackTrace();
      }
    }
  }


}
