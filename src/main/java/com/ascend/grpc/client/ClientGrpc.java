package com.ascend.grpc.client;

import com.ascend.proto.Greeting;
import com.ascend.proto.GreetingRequest;
import com.ascend.proto.GreetingResponse;
import com.ascend.proto.GreetingServiceGrpc;
import com.ascend.proto.SumElements;
import com.ascend.proto.SumRequest;
import com.ascend.proto.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class ClientGrpc {
  GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;
  GreetingServiceGrpc.GreetingServiceStub asyncStub;

  public static void main(String[] args) {
    System.out.println("this is grpc client");
    ClientGrpc grpc = new ClientGrpc();
    grpc.run();
  }

  public void run(){
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
        .usePlaintext()
        .build();
    blockingStub = GreetingServiceGrpc.newBlockingStub(channel);

//    doUnaryCall();
//    doSumElements();
//    doStreamingServer();
    doStreamingClient(channel);

    System.out.println("shutting down channel");
    channel.shutdown();
    //channel
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
}
