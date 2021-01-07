package org.starrier.sky.ladder.distribution.rsocket.service.server;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class ChannelClient {

    public static void main(String[] args) {

    }

    public static void channel() {
        RSocket socket = RSocketConnector.connectWith(TcpClientTransport.create("localhost", 7004)).block();
        socket.requestChannel(
                Flux.interval(Duration.ofMillis(1000)).map(i -> DefaultPayload.create("我是客户端啊")))
                .map(Payload::getDataUtf8)
                .doOnNext(System.out::println)
                .take(10)
                .doFinally(signalType -> socket.dispose())
                .then()
                .block();

    }
}
