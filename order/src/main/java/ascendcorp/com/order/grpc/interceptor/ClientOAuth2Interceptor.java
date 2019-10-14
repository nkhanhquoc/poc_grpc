package ascendcorp.com.order.grpc.interceptor;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

public class ClientOAuth2Interceptor implements ClientInterceptor {

  private String token;

  public ClientOAuth2Interceptor(String token) {
    this.token = token;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {

    return new SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {

      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        System.out.println("Prepare add OAuth2 authorization to header");
        headers.put(Metadata.Key.of("Authorization",Metadata.ASCII_STRING_MARSHALLER),"Bearer "+token);

        super.start(responseListener, headers);
      }
    };
  }
}
