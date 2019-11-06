package org.mvnsearch.servicetalk.grpc;

import io.grpc.examples.helloworld.Greeter.GreeterService;
import io.grpc.examples.helloworld.Greeter.ServiceFactory;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.servicetalk.concurrent.api.Single;
import io.servicetalk.grpc.api.GrpcServiceContext;
import io.servicetalk.grpc.netty.GrpcServers;

import static io.servicetalk.concurrent.api.Single.succeeded;

/**
 * hello grpc Server
 *
 * @author linux_china
 */
public class HelloGrpcServer {
    public static void main(String[] args) throws Exception {
        GrpcServers.forPort(50051)
                .listenAndAwait(new ServiceFactory(new MyGreeterService()))
                .awaitShutdown();
    }

    private static final class MyGreeterService implements GreeterService {

        @Override
        public Single<HelloReply> sayHello(final GrpcServiceContext ctx, final HelloRequest request) {
            return succeeded(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
        }
    }
}
