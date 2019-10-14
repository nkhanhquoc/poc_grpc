package ascendcorp.com.order.config;

import io.grpc.ServerBuilder;
import io.prometheus.client.CollectorRegistry;
import me.dinowernli.grpc.prometheus.Configuration;
import me.dinowernli.grpc.prometheus.MonitoringServerInterceptor;
import org.springframework.stereotype.Component;

@Component
public class GRpcServerBuilderConfigurer extends
    org.lognet.springboot.grpc.GRpcServerBuilderConfigurer {

  private CollectorRegistry collectorRegistry = new CollectorRegistry();

//  MonitoringServerInterceptor monitoringInterceptor =
//      MonitoringServerInterceptor.create(Configuration.cheapMetricsOnly());

  MonitoringServerInterceptor monitoringInterceptor =
      MonitoringServerInterceptor.create(Configuration.cheapMetricsOnly().withCollectorRegistry(collectorRegistry));

  @Override
  public void configure(ServerBuilder<?> serverBuilder) {
    serverBuilder.intercept(monitoringInterceptor);
  }


}
