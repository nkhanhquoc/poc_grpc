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
//    super.sum(request, responseObserver);
  }
}
