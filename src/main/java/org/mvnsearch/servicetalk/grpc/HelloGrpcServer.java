package org.mvnsearch.servicetalk.grpc;

import io.grpc.examples.helloworld.Greeter.ServiceFactory;
import io.servicetalk.grpc.netty.GrpcServers;

/**
 * hello gRPC Server
 *
 * @author linux_china
 */
public class HelloGrpcServer {

    public static void main(String[] args) throws Exception {
        ServiceFactory[] serviceFactories = new ServiceFactory[]{new ServiceFactory(new MyGreeterService())};
        GrpcServers.forPort(50051)
                .listenAndAwait(serviceFactories)
                .awaitShutdown();
    }

}
