package org.starrier.sky.ladder.distribution.rsocket.service.server;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RequestResponse {

    public void requestResponse() throws InterruptedException {
        // RSocket类能够提供多种通讯模型，此处用到的就是request-response
        RSocket rsocket = new RSocket() {
            boolean fail = false;

            // Mono表示 最多返回一个Payload，Payload裹挟着数据
            @Override
            public Mono<Payload> requestResponse(Payload p) {
                if (fail) {
                    fail = false;
                    return Mono.error(new Throwable("发生异常"));
                } else {
                    return Mono.just(DefaultPayload.create("这是服务端对：" + p.getDataUtf8() + "的返回"));
                }
            }
        };

        // RSocketServer是用于创建RSocket服务的类
        // SocketAcceptor.with指定以rsocket的形式创建两端连接
        // subscribe方法用于订阅连接上返回的消息
        RSocketServer.create(SocketAcceptor.with(rsocket))
                .bind(TcpServerTransport.create("localhost", 7000))
                .subscribe();
        // 由于server监听是用的其他线程，相当于异步，所以让主线程不要死掉
        TimeUnit.MINUTES.sleep(10);

    }
}
