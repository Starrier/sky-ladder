package org.starrier.sky.ladder.distribution.rsocket.service.server;

import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class FireAndForget {

    public static void main(String[] args) {

    }

    public void fireAndForget() throws InterruptedException {

        RSocketServer.create(SocketAcceptor.forFireAndForget(payload -> {
            System.out.println(payload.getDataUtf8());
            return Mono.empty();
        })).bind(TcpServerTransport.create("localhost", 7001))
                .doOnSuccess(msg -> System.out.println(Thread.currentThread().getName()))
                .doOnNext(System.out::println)
                .doOnError(System.out::println)
                .block();
        TimeUnit.MINUTES.sleep(10);

    }
}
