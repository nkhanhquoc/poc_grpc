package ascendcorp.com.order.grpc;

import ascendcorp.com.order.GrpcOrder;
import ascendcorp.com.order.OrderRequest;
import ascendcorp.com.order.OrderResponse;
import ascendcorp.com.order.VerifyServiceGrpc;
import ascendcorp.com.order.constant.JwtConstants;
import ascendcorp.com.order.logger.Logger;
import ascendcorp.com.order.grpc.credentials.JwtCallCredential;
import ascendcorp.com.order.grpc.interceptor.ClientBasicAuthInterceptor;
import ascendcorp.com.order.grpc.interceptor.ClientOAuth2Interceptor;
import brave.grpc.GrpcTracing;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.MetadataUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.prometheus.client.CollectorRegistry;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import me.dinowernli.grpc.prometheus.Configuration;
import me.dinowernli.grpc.prometheus.MonitoringClientInterceptor;
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties({GRpcServerProperties.class})
public class ClientGrpc{

  private static final Logger logger = Logger.getInstance(ClientGrpc.class);
  ManagedChannel channel;
  private CollectorRegistry collectorRegistry = new CollectorRegistry();

  public ClientGrpc(GRpcServerProperties grpcServerProperties, GrpcTracing grpcTracing) throws IOException {

    MonitoringClientInterceptor monitoringInterceptor =
        MonitoringClientInterceptor.create(Configuration.cheapMetricsOnly().withCollectorRegistry(collectorRegistry));

    this.channel = NettyChannelBuilder.
        forAddress("localhost",50051)
        .intercept(grpcTracing.newClientInterceptor())
//        .intercept(monitoringInterceptor)
//        .keepAliveTime(2000, TimeUnit.MILLISECONDS)
        .sslContext(
            GrpcSslContexts
                .forClient()
                .trustManager(grpcServerProperties.getSecurity().getCertChain().getFile())
                .build())
        .build();
  }

  public GrpcOrder sendOrderBasic(String value){

    logger.info("Call GRPC server with basic auth");
    VerifyServiceGrpc.VerifyServiceBlockingStub verifyStub =
        VerifyServiceGrpc
            .newBlockingStub(channel)
            .withInterceptors(new ClientBasicAuthInterceptor());

    OrderResponse response = verifyStub.verifyOrder(OrderRequest.newBuilder()
        .setOrderId(value)
        .build());

    logger.info("response from grpc server: "+response.getOrder());
    return response.getOrder();

  }

  public GrpcOrder sendOrderOAuth2(String value, String token){

    VerifyServiceGrpc.VerifyServiceBlockingStub verifyStub =
        VerifyServiceGrpc
            .newBlockingStub(channel)
            .withInterceptors(new ClientOAuth2Interceptor(token));
//for OAuth2
//    verifyStub = token(verifyStub, token);

    OrderResponse response = verifyStub.verifyOrder(OrderRequest.newBuilder()
        .setOrderId(value)
        .build());

    logger.info("response from grpc server: "+response.getOrder());
    return response.getOrder();

  }

  public GrpcOrder sendOrderJwt(String value){

    //for JWT
    String jwt = getJwt();
    logger.info("JWT Token: {}",jwt);
    JwtCallCredential jwtToken = new JwtCallCredential(jwt);

    VerifyServiceGrpc.VerifyServiceBlockingStub verifyStub =
        VerifyServiceGrpc
            .newBlockingStub(channel)
            .withCallCredentials(jwtToken);
    OrderResponse response = verifyStub.verifyOrder(OrderRequest.newBuilder()
        .setOrderId(value)
        .build());
    logger.info("response from grpc server: "+response.getOrder());
    return response.getOrder();

  }

  private VerifyServiceGrpc.VerifyServiceBlockingStub token(
      VerifyServiceGrpc.VerifyServiceBlockingStub stub, String token){

    Metadata metadata = new Metadata();
    metadata.put(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER),
        "Bearer "+token);
    stub = MetadataUtils.attachHeaders(stub,metadata);
    return stub;
  }

  private static String getJwt() {
    List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        .commaSeparatedStringToAuthorityList("ROLE_USER");

    return Jwts.builder()
        .setSubject("test1") // client's identifier
        .claim("authorities", grantedAuthorities.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList()))
        .signWith(SignatureAlgorithm.HS256, JwtConstants.JWT_SIGNING_KEY)
        .compact();
  }


}
