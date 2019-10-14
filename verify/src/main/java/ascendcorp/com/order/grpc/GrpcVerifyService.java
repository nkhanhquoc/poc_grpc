package ascendcorp.com.order.grpc;

import ascendcorp.com.order.GrpcOrder;
import ascendcorp.com.order.OrderRequest;
import ascendcorp.com.order.OrderResponse;
import ascendcorp.com.order.VerifyServiceGrpc;
import ascendcorp.com.order.entity.OrderEntity;
import ascendcorp.com.order.exception.GrpcErrorInterceptor;
import ascendcorp.com.order.logger.Logger;
import ascendcorp.com.order.mapper.OrderMapper;
import ascendcorp.com.order.mapper.VerifyOrderMapper;
import ascendcorp.com.order.model.Order;
import ascendcorp.com.order.repository.OrderRepository;
import ascendcorp.com.order.repository.VerifyOrderRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.security.access.prepost.PreAuthorize;

@GRpcService(interceptors = { GrpcErrorInterceptor.class })
public class GrpcVerifyService extends VerifyServiceGrpc.VerifyServiceImplBase {

  private static final Logger logger = Logger.getInstance(GrpcVerifyService.class);

  private VerifyOrderRepository verifyOrderRepository;
  private OrderRepository orderRepository;
  private VerifyOrderMapper mapper;
  private OrderMapper orderMapper;

  public GrpcVerifyService(
      VerifyOrderRepository verifyOrderRepository,
      OrderRepository orderRepository,
      OrderMapper orderMapper,
      VerifyOrderMapper mapper) {
    this.verifyOrderRepository = verifyOrderRepository;
    this.orderRepository = orderRepository;
    this.orderMapper = orderMapper;
    this.mapper = mapper;
  }

  @Override
  @PreAuthorize("hasRole('USER')")
  public void verifyOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {

    String orderId = request.getOrderId();

    OrderEntity entity = orderRepository.getOne(orderId);

    if (request.getOrderId().equals(entity.getId())) {
      Order order = orderMapper.transform(entity);

      logger.info("get order: {}", order);

      OrderResponse response = OrderResponse.newBuilder()
          .setOrder(
              GrpcOrder.newBuilder()
                  .setValue(order.getValue())
                  .setStatus(order.getStatus())
                  .setId(order.getId())
                  .setMessage(order.getMessage())
                  .build()
          )
          .build();
//
      responseObserver.onNext(response);
    } else {
      responseObserver.onError(
          Status.NOT_FOUND
              .withDescription("Order not found")
              .asRuntimeException()
      );
    }

    responseObserver.onCompleted();

  }
}
