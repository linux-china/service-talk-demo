package org.mvnsearch.servicetalk.grpc;

import io.servicetalk.grpc.netty.GrpcServers;

/**
 * hello gRPC Server
 *
 * @author linux_china
 */
public class HelloGrpcServer {

    public static void main(String[] args) throws Exception {
        GrpcServers.forPort(50052)
                .listenAndAwait(new MyGreeterService())
                .awaitShutdown();
    }

}
