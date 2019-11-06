package org.mvnsearch.servicetalk.grpc;

import io.grpc.examples.helloworld.Greeter;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.servicetalk.concurrent.api.Single;
import io.servicetalk.grpc.api.GrpcServiceContext;

import static io.servicetalk.concurrent.api.Single.succeeded;

/**
 * My Greeter gRPC Service
 *
 * @author linux_china
 */
final class MyGreeterService implements Greeter.GreeterService {

    @Override
    public Single<HelloReply> sayHello(final GrpcServiceContext ctx, final HelloRequest request) {
        return succeeded(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
    }
}
