package ascendcorp.com.order.grpc;

import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcVerifyServiceTest {

  @Rule
  public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

}