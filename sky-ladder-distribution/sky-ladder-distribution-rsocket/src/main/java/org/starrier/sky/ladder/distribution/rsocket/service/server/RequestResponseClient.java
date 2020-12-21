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
public class RequestResponseClient {

    public static void main(String[] args) {
        RSocket socketClient =
                RSocketConnector.connectWith(TcpClientTransport.create("localhost", 7000)).block();

        // Payload create用于构建消息
        // doOnNext用于处理收到的连接上的信息
        // block阻塞等待直到连接上有消息到来
        for (int i = 0; i < 10; i++) {
            socketClient
                    .requestResponse(DefaultPayload.create("客户端消息 " + i))
                    .map(Payload::getDataUtf8)
                    .onErrorReturn("error")
                    .doOnNext(System.out::println)
                    .block();
        }
        // 切断连接
        socketClient.dispose();

    }
}
