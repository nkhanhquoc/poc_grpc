package com.ascend.grpc.server;

import com.ascend.proto.GreetingRequest;
import com.ascend.proto.GreetingResponse;
import com.ascend.proto.GreetingServiceGrpc.GreetingServiceImplBase;
import com.ascend.proto.SumRequest;
import com.ascend.proto.SumResponse;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetingServiceImplBase {

  @Override
  public void hello(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
//    super.hello(request, responseObserver);
    String result = "Hello "+request.getGreeting().getGreeting();
    GreetingResponse res = GreetingResponse.newBuilder()
        .setResult(result)
        .build();
    responseObserver.onNext(res);

    responseObserver.onCompleted();
  }

  @Override
  public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {

    int sum = request.getSumElement().getFirstNumber() + request.getSumElement().getSecondNumnber();

    SumResponse sumResponse = SumResponse.newBuilder()
        .setResult(sum)
        .build();
    responseObserver.onNext(sumResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void helloManyTimes(GreetingRequest request,
      StreamObserver<GreetingResponse> responseObserver) {
      try {
        for (int i = 0;i< 10; i++){
          GreetingResponse response = GreetingResponse.newBuilder()
              .setResult("Hello "+request.getGreeting().getGreeting()+" times: "+i)
              .build();
          responseObserver.onNext(response);
          Thread.sleep(1000L);
        }
      }catch (InterruptedException e){
        e.printStackTrace();
      } finally {
        responseObserver.onCompleted();
      }
  }

  @Override
  public StreamObserver<GreetingRequest> longHello(
      StreamObserver<GreetingResponse> responseObserver) {

    StreamObserver<GreetingRequest> streamObserverRequest = new StreamObserver<GreetingRequest>() {
      String result = "";
      @Override
      public void onNext(GreetingRequest greetingRequest) {
        result += "Hello "+ greetingRequest.getGreeting().getGreeting()+"! ";
      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(
            GreetingResponse
                .newBuilder()
                .setResult(result)
                .build());
        responseObserver.onCompleted();
      }

    };
    return streamObserverRequest;
  }

  @Override
  public StreamObserver<GreetingRequest> helloEveryone(
      StreamObserver<GreetingResponse> responseObserver) {

    StreamObserver<GreetingRequest> streamObserver = new StreamObserver<GreetingRequest>() {
      @Override
      public void onNext(GreetingRequest greetingRequest) {
        GreetingResponse response = GreetingResponse.newBuilder()
            .setResult("Hello "+greetingRequest.getGreeting().getGreeting())
            .build();
        responseObserver.onNext(response);
      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
    return streamObserver;
  }
}
