package com.ascend.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServerGrpc {

  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Starting GPRC server....");

    Server server = ServerBuilder
        .forPort(50051)
        .addService(new GreetServiceImpl())
        .build();
    server.start();

    System.out.println("GRPC Server has been started.....");

    Runtime.getRuntime().addShutdownHook(new Thread(()->{
      System.out.println("Get Shutdown Signal");
      server.shutdown();
      System.out.printf("Shutdown success");
    }));
    server.awaitTermination();
  }

}
