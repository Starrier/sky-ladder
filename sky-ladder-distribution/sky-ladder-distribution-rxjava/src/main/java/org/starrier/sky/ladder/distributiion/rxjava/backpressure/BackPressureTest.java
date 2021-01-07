package org.starrier.sky.ladder.distributiion.rxjava.backpressure;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

/**
 * @author starrier
 * @date 2020/12/22
 */
public class BackPressureTest {

    public static void main(String[] args) {
        backpressure();
    }

    public static void backpressure() {

        // Flux.range是一个快的Publisher；
        Flux.range(1, 6)
                .doOnRequest(n -> System.out.println("current consumer info is " + n))
                // 通过重写 BaseSubscriber 的方法来自定义 Subscriber；
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    //  hookOnSubscribe定义在订阅的时候执行的操作；
                    protected void hookOnSubscribe(Subscription subscription) {
                        System.out.println("Subscribed and make a request...");
                        // 订阅时首先向上游请求1个元素
                        request(1);
                    }

                    @Override
                    // hookOnNext 定义每次在收到一个元素的时候的操作；
                    protected void hookOnNext(Integer value) {
                        try {
                            //  sleep 1秒钟来模拟慢的Subscriber；
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 打印接受到的参数
                        System.out.println("Get value [" + value + "]");
                        // 每次处理完1个元素后再请求1个。
                        request(1);
                    }
                });
    }
}
