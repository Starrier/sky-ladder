package org.starrier.sky.ladder.distribution.rsocket.service.server;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RequestStream {

    public void requestStream(){
        RSocket socket =
                RSocketConnector.connectWith(TcpClientTransport.create("localhost", 7000)).block();

        // take（10）只取10条流数据
        socket
                .requestStream(DefaultPayload.create("Hello"))
                .map(Payload::getDataUtf8)
                .doOnNext(System.out::println)
                .take(10)
                .then()
                .doFinally(signalType -> socket.dispose())
                .then()
                .block();

    }
}
