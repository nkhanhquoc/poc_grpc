package ascendcorp.com.order.exception;

import ascendcorp.com.order.logger.Logger;
import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;

//@GRpcGlobalInterceptor
public class GrpcErrorInterceptor implements ServerInterceptor {

  private final List<Class<? extends Throwable>> autowrapThrowables = Arrays.asList(
      RuntimeException.class
  );

  private static final Logger logger = Logger.getInstance(GrpcErrorInterceptor.class);

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall,
      Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

    ServerCall<ReqT, RespT> wrappedCall = new SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
      @Override
      public void sendMessage(RespT message) {
        super.sendMessage(message);
      }

      @Override
      public void close(Status status, Metadata trailers) {

        logger.info("Error Interceptor "+(status.getCause() == null ? "null" : status.getCause().getClass().getName()));

        if (status.getCode() == Status.Code.UNKNOWN
            && status.getDescription() == null
            && status.getCause() != null
            && autowrapThrowables.contains(status.getCause().getClass())) {
          logger.info("Catch error");
          Throwable e = status.getCause();
          status = Status.INTERNAL
              .withDescription(e.getMessage())
              .augmentDescription(stacktraceToString(e));
        }
        super.close(status, trailers);
      }
    };

    return serverCallHandler.startCall(wrappedCall, metadata);
  }

  private String stacktraceToString(Throwable e) {
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace(printWriter);
    return stringWriter.toString();
  }
}
