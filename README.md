# poc_grpc
this is poc about grpc

Call with OAuth2

1. Get Token
+ Open browser and access to url: 
  http://localhost:8082/oauth/authorize?client_id=client&response_type=token&scope=grpc&redirect_uri=http://localhost:8082
+ Approval, and the browser will redirect to an url like this: 
  http://localhost:8082/#access_token=a334c0cc-6672-48e4-bf13-77f3268bb146&token_type=bearer&expires_in=82
+ Coyp token from url.

2. Call with token

http://localhost:8081/order-grpc-oauth2?order=97a6e15d-3028-4699-941d-b043ab6a4797&token=a334c0cc-6672-48e4-bf13-77f3268bb146
