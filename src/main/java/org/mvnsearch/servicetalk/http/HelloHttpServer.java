package org.mvnsearch.servicetalk.http;

import io.servicetalk.data.jackson.JacksonSerializationProvider;
import io.servicetalk.http.api.HttpSerializationProvider;
import io.servicetalk.http.api.HttpSerializer;
import io.servicetalk.http.netty.HttpServers;

import static io.servicetalk.concurrent.api.Single.succeeded;
import static io.servicetalk.http.api.HttpSerializationProviders.jsonSerializer;

/**
 * Service Talk HTTP Server
 *
 * @author linux_china
 */
public class HelloHttpServer {
    public static void main(String[] args) throws Exception {
        HttpSerializationProvider httpSerializationProvider = jsonSerializer(new JacksonSerializationProvider());
        HttpSerializer<User> userHttpSerializer = httpSerializationProvider.serializerFor(User.class);

        HttpServers.forPort(8080)
                .listenAndAwait((ctx, request, responseFactory) ->
                        succeeded(responseFactory
                                .ok()
                                .payloadBody(new User(1, "Jackie"), userHttpSerializer)
                        )
                )
                .awaitShutdown();
    }


}
