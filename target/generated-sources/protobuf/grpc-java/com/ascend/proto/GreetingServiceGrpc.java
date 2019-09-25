package com.ascend.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: com/ascend/proto/greetings.proto")
public final class GreetingServiceGrpc {

  private GreetingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.ascend.proto.GreetingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Hello",
      requestType = com.ascend.proto.GreetingRequest.class,
      responseType = com.ascend.proto.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse> getHelloMethod;
    if ((getHelloMethod = GreetingServiceGrpc.getHelloMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getHelloMethod = GreetingServiceGrpc.getHelloMethod) == null) {
          GreetingServiceGrpc.getHelloMethod = getHelloMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("Hello"))
              .build();
        }
      }
    }
    return getHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.SumRequest,
      com.ascend.proto.SumResponse> getSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sum",
      requestType = com.ascend.proto.SumRequest.class,
      responseType = com.ascend.proto.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ascend.proto.SumRequest,
      com.ascend.proto.SumResponse> getSumMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.SumRequest, com.ascend.proto.SumResponse> getSumMethod;
    if ((getSumMethod = GreetingServiceGrpc.getSumMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getSumMethod = GreetingServiceGrpc.getSumMethod) == null) {
          GreetingServiceGrpc.getSumMethod = getSumMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.SumRequest, com.ascend.proto.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Sum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("Sum"))
              .build();
        }
      }
    }
    return getSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloManyTimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloManyTimes",
      requestType = com.ascend.proto.GreetingRequest.class,
      responseType = com.ascend.proto.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloManyTimesMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse> getHelloManyTimesMethod;
    if ((getHelloManyTimesMethod = GreetingServiceGrpc.getHelloManyTimesMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getHelloManyTimesMethod = GreetingServiceGrpc.getHelloManyTimesMethod) == null) {
          GreetingServiceGrpc.getHelloManyTimesMethod = getHelloManyTimesMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloManyTimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("HelloManyTimes"))
              .build();
        }
      }
    }
    return getHelloManyTimesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getLongHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LongHello",
      requestType = com.ascend.proto.GreetingRequest.class,
      responseType = com.ascend.proto.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getLongHelloMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse> getLongHelloMethod;
    if ((getLongHelloMethod = GreetingServiceGrpc.getLongHelloMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getLongHelloMethod = GreetingServiceGrpc.getLongHelloMethod) == null) {
          GreetingServiceGrpc.getLongHelloMethod = getLongHelloMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LongHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("LongHello"))
              .build();
        }
      }
    }
    return getLongHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloEveryoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloEveryone",
      requestType = com.ascend.proto.GreetingRequest.class,
      responseType = com.ascend.proto.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloEveryoneMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse> getHelloEveryoneMethod;
    if ((getHelloEveryoneMethod = GreetingServiceGrpc.getHelloEveryoneMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getHelloEveryoneMethod = GreetingServiceGrpc.getHelloEveryoneMethod) == null) {
          GreetingServiceGrpc.getHelloEveryoneMethod = getHelloEveryoneMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloEveryone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("HelloEveryone"))
              .build();
        }
      }
    }
    return getHelloEveryoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.SquareRootRequest,
      com.ascend.proto.SquareRootResponse> getSquareRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SquareRoot",
      requestType = com.ascend.proto.SquareRootRequest.class,
      responseType = com.ascend.proto.SquareRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ascend.proto.SquareRootRequest,
      com.ascend.proto.SquareRootResponse> getSquareRootMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.SquareRootRequest, com.ascend.proto.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = GreetingServiceGrpc.getSquareRootMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getSquareRootMethod = GreetingServiceGrpc.getSquareRootMethod) == null) {
          GreetingServiceGrpc.getSquareRootMethod = getSquareRootMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.SquareRootRequest, com.ascend.proto.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.SquareRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.SquareRootResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("SquareRoot"))
              .build();
        }
      }
    }
    return getSquareRootMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloWithDeadlineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloWithDeadline",
      requestType = com.ascend.proto.GreetingRequest.class,
      responseType = com.ascend.proto.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest,
      com.ascend.proto.GreetingResponse> getHelloWithDeadlineMethod() {
    io.grpc.MethodDescriptor<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse> getHelloWithDeadlineMethod;
    if ((getHelloWithDeadlineMethod = GreetingServiceGrpc.getHelloWithDeadlineMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getHelloWithDeadlineMethod = GreetingServiceGrpc.getHelloWithDeadlineMethod) == null) {
          GreetingServiceGrpc.getHelloWithDeadlineMethod = getHelloWithDeadlineMethod =
              io.grpc.MethodDescriptor.<com.ascend.proto.GreetingRequest, com.ascend.proto.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloWithDeadline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ascend.proto.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("HelloWithDeadline"))
              .build();
        }
      }
    }
    return getHelloWithDeadlineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetingServiceStub newStub(io.grpc.Channel channel) {
    return new GreetingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreetingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreetingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GreetingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hello(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    /**
     */
    public void sum(com.ascend.proto.SumRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSumMethod(), responseObserver);
    }

    /**
     */
    public void helloManyTimes(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloManyTimesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ascend.proto.GreetingRequest> longHello(
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLongHelloMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ascend.proto.GreetingRequest> helloEveryone(
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getHelloEveryoneMethod(), responseObserver);
    }

    /**
     */
    public void squareRoot(com.ascend.proto.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSquareRootMethod(), responseObserver);
    }

    /**
     */
    public void helloWithDeadline(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloWithDeadlineMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ascend.proto.GreetingRequest,
                com.ascend.proto.GreetingResponse>(
                  this, METHODID_HELLO)))
          .addMethod(
            getSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ascend.proto.SumRequest,
                com.ascend.proto.SumResponse>(
                  this, METHODID_SUM)))
          .addMethod(
            getHelloManyTimesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ascend.proto.GreetingRequest,
                com.ascend.proto.GreetingResponse>(
                  this, METHODID_HELLO_MANY_TIMES)))
          .addMethod(
            getLongHelloMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.ascend.proto.GreetingRequest,
                com.ascend.proto.GreetingResponse>(
                  this, METHODID_LONG_HELLO)))
          .addMethod(
            getHelloEveryoneMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.ascend.proto.GreetingRequest,
                com.ascend.proto.GreetingResponse>(
                  this, METHODID_HELLO_EVERYONE)))
          .addMethod(
            getSquareRootMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ascend.proto.SquareRootRequest,
                com.ascend.proto.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .addMethod(
            getHelloWithDeadlineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ascend.proto.GreetingRequest,
                com.ascend.proto.GreetingResponse>(
                  this, METHODID_HELLO_WITH_DEADLINE)))
          .build();
    }
  }

  /**
   */
  public static final class GreetingServiceStub extends io.grpc.stub.AbstractStub<GreetingServiceStub> {
    private GreetingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingServiceStub(channel, callOptions);
    }

    /**
     */
    public void hello(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sum(com.ascend.proto.SumRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.SumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void helloManyTimes(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getHelloManyTimesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ascend.proto.GreetingRequest> longHello(
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLongHelloMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ascend.proto.GreetingRequest> helloEveryone(
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHelloEveryoneMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void squareRoot(com.ascend.proto.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void helloWithDeadline(com.ascend.proto.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloWithDeadlineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GreetingServiceBlockingStub extends io.grpc.stub.AbstractStub<GreetingServiceBlockingStub> {
    private GreetingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ascend.proto.GreetingResponse hello(com.ascend.proto.GreetingRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ascend.proto.SumResponse sum(com.ascend.proto.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getSumMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ascend.proto.GreetingResponse> helloManyTimes(
        com.ascend.proto.GreetingRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getHelloManyTimesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ascend.proto.SquareRootResponse squareRoot(com.ascend.proto.SquareRootRequest request) {
      return blockingUnaryCall(
          getChannel(), getSquareRootMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ascend.proto.GreetingResponse helloWithDeadline(com.ascend.proto.GreetingRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloWithDeadlineMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreetingServiceFutureStub extends io.grpc.stub.AbstractStub<GreetingServiceFutureStub> {
    private GreetingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ascend.proto.GreetingResponse> hello(
        com.ascend.proto.GreetingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ascend.proto.SumResponse> sum(
        com.ascend.proto.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ascend.proto.SquareRootResponse> squareRoot(
        com.ascend.proto.SquareRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ascend.proto.GreetingResponse> helloWithDeadline(
        com.ascend.proto.GreetingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloWithDeadlineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HELLO = 0;
  private static final int METHODID_SUM = 1;
  private static final int METHODID_HELLO_MANY_TIMES = 2;
  private static final int METHODID_SQUARE_ROOT = 3;
  private static final int METHODID_HELLO_WITH_DEADLINE = 4;
  private static final int METHODID_LONG_HELLO = 5;
  private static final int METHODID_HELLO_EVERYONE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          serviceImpl.hello((com.ascend.proto.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse>) responseObserver);
          break;
        case METHODID_SUM:
          serviceImpl.sum((com.ascend.proto.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.ascend.proto.SumResponse>) responseObserver);
          break;
        case METHODID_HELLO_MANY_TIMES:
          serviceImpl.helloManyTimes((com.ascend.proto.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.ascend.proto.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.ascend.proto.SquareRootResponse>) responseObserver);
          break;
        case METHODID_HELLO_WITH_DEADLINE:
          serviceImpl.helloWithDeadline((com.ascend.proto.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LONG_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.longHello(
              (io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse>) responseObserver);
        case METHODID_HELLO_EVERYONE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.helloEveryone(
              (io.grpc.stub.StreamObserver<com.ascend.proto.GreetingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreetingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreetingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ascend.proto.Greetings.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GreetingService");
    }
  }

  private static final class GreetingServiceFileDescriptorSupplier
      extends GreetingServiceBaseDescriptorSupplier {
    GreetingServiceFileDescriptorSupplier() {}
  }

  private static final class GreetingServiceMethodDescriptorSupplier
      extends GreetingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreetingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreetingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetingServiceFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .addMethod(getSumMethod())
              .addMethod(getHelloManyTimesMethod())
              .addMethod(getLongHelloMethod())
              .addMethod(getHelloEveryoneMethod())
              .addMethod(getSquareRootMethod())
              .addMethod(getHelloWithDeadlineMethod())
              .build();
        }
      }
    }
    return result;
  }
}
