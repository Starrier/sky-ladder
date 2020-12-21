package org.starrier.sky.ladder.distribution.rsocket.service;

import reactor.core.publisher.Mono;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RSocketService {

    public static void main(String[] args) {

    }

    private static void clientService(){
      /*  RSocketFactory.receive()
                .acceptor(
                        (setupPayload, reactiveSocket) ->
                                Mono.just(
                                        new AbstractRSocket() {
                                            @Override
                                            public Mono<Void> fireAndForget(Payload payload) {
                                                System.out.printf("fire-forget: %s%n", payload.getDataUtf8());
                                                return Mono.empty();
                                            }
                                        }))
                .transport(TcpServerTransport.create("localhost", 8080))
                .start()
                .subscribe();

        //CLIENT
        RSocket socket =
                RSocketFactory.connect()
                        .transport(TcpClientTransport.create("localhost", 8080))
                        .start()
                        .block();

        socket
                .fireAndForget(DefaultPayload.create("Hello"))
                .block();

        socket.dispose();

        TimeUnit.SECONDS.sleep(5);*/
    }
}
