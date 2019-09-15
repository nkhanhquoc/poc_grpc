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


public class ClientGrpc {

  public static void main(String[] args) {
    System.out.println("this is grpc client");
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
        .usePlaintext()
        .build();

    GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub = GreetingServiceGrpc.newBlockingStub(channel);

    Greeting greeting = Greeting.newBuilder()
        .setGreeting("Khanh")
        .build();
    GreetingRequest req = GreetingRequest.newBuilder()
        .setGreeting(greeting)
        .build();

    GreetingResponse response = blockingStub.hello(req);

    System.out.println(response.getResult());

    SumElements elements = SumElements.newBuilder()
        .setFirstNumber(1593)
        .setSecondNumnber(345)
        .build();
    SumRequest sumRequest = SumRequest.newBuilder()
        .setSumElement(elements)
        .build();
    SumResponse sumResponse = blockingStub.sum(sumRequest);
    System.out.println("sum result: "+sumResponse.getResult());

    //do something;
    System.out.println("shutting down channel");
    channel.shutdown();
    //channel
  }
}
