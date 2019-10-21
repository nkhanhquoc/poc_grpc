package ascendcorp.com.order;

//import io.opencensus.contrib.grpc.metrics.RpcViews;
//import io.opencensus.exporter.stats.prometheus.PrometheusStatsCollector;
//import io.opencensus.exporter.trace.jaeger.JaegerTraceExporter;
//import io.prometheus.client.exporter.HTTPServer;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VerifyApplication {

	public static void main(String[] args) throws IOException {

//		PrometheusStatsCollector.createAndRegister();
//		RpcViews.registerServerGrpcViews();
//
//
//		io.prometheus.client.exporter.HTTPServer server =
//				new HTTPServer(/*host*/ "localhost", /*port*/  9091, /*daemon*/ true);

		SpringApplication.run(VerifyApplication.class, args);
	}

}
