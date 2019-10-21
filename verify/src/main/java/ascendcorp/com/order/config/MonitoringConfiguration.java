package ascendcorp.com.order.config;

import io.grpc.ServerInterceptor;
import io.prometheus.client.CollectorRegistry;
import me.dinowernli.grpc.prometheus.MonitoringServerInterceptor;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfiguration {


//  @Bean
//  public GrpcTracing grpcTracing(Tracing tracing) {
//    return GrpcTracing.create(tracing);
//  }

//  @Bean
//  @GRpcGlobalInterceptor
//  public ServerInterceptor grpcServerInterceptor(GrpcTracing grpcTracing) {
//    return grpcTracing.newServerInterceptor();
//  }

  @Bean
  @GRpcGlobalInterceptor
  public ServerInterceptor monitoringServerInterceptor(){
    System.out.println("monitoringServerInterceptor");
    CollectorRegistry collectorRegistry = new CollectorRegistry();

    MonitoringServerInterceptor monitoringInterceptor =
        MonitoringServerInterceptor.create(
            me.dinowernli.grpc.prometheus.Configuration.cheapMetricsOnly().withCollectorRegistry(collectorRegistry));
    return monitoringInterceptor;
  }


}
