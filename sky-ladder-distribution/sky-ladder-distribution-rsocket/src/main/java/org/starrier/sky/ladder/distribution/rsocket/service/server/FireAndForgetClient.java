package org.starrier.sky.ladder.distribution.rsocket.service.server;

import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class FireAndForgetClient {

    public void fireAndForgetClient()  {

        RSocket socketClient = RSocketConnector
                .connectWith(TcpClientTransport.create("localhost", 7001))
                .block();

        IntStream.range(1,10).forEach(i->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            socketClient.fireAndForget(DefaultPayload.create("客户端消息FireAndForget"+i)).block();
        });

    }
}
