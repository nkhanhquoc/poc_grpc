package ascendcorp.com.order.controller;

import ascendcorp.com.order.GrpcOrder;
import ascendcorp.com.order.logger.Logger;
import ascendcorp.com.order.model.Order;
import ascendcorp.com.order.grpc.ClientGrpc;
import ascendcorp.com.order.ulti.ResponseFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private static final Logger logger = Logger.getInstance(OrderController.class);

  private final ClientGrpc clientGrpc;

  public OrderController(ClientGrpc clientGrpc) {
    this.clientGrpc = clientGrpc;
  }

  @GetMapping("/order-grpc-basic")
  public ResponseEntity orderGrpcBasic(@RequestParam("order") String value){

    logger.info("GRPC get request: {}",value);
    GrpcOrder grpcOrder = clientGrpc.sendOrderBasic(value);
    Order order = Order.builder()
        .id(grpcOrder.getId())
        .value(grpcOrder.getValue())
        .status(grpcOrder.getStatus())
        .message(grpcOrder.getMessage())
        .build();
    return ResponseFactory.success(order);
  }

  @GetMapping("/order-grpc-oauth2")
  public ResponseEntity orderGrpcOAuth2(@RequestParam("order") String value, @RequestParam("token") String token){

    logger.info("GRPC get request: {}",value);
    GrpcOrder grpcOrder = clientGrpc.sendOrderOAuth2(value, token);
    Order order = Order.builder()
        .id(grpcOrder.getId())
        .value(grpcOrder.getValue())
        .status(grpcOrder.getStatus())
        .message(grpcOrder.getMessage())
        .build();
    return ResponseFactory.success(order);
  }

  @GetMapping("/order-grpc-jwt")
  public ResponseEntity orderGrpcJwt(@RequestParam("order") String value){

    logger.info("GRPC get request: {}",value);
    GrpcOrder grpcOrder = clientGrpc.sendOrderJwt(value);
    Order order = Order.builder()
        .id(grpcOrder.getId())
        .value(grpcOrder.getValue())
        .status(grpcOrder.getStatus())
        .message(grpcOrder.getMessage())
        .build();
    return ResponseFactory.success(order);
  }


}
