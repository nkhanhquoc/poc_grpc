package ascendcorp.com.order.config;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ServerInterceptor;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {

//  @Bean
//  public GrpcTracing grpcTracing(Tracing tracing) {
//    return GrpcTracing.create(tracing);
//  }

  @Bean
  @GRpcGlobalInterceptor
  public ServerInterceptor grpcServerInterceptor(GrpcTracing grpcTracing) {
    return grpcTracing.newServerInterceptor();
  }


}
