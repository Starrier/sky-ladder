package org.starrier.sky.ladder.distributiion.rxjava.subscriber;

import reactor.core.publisher.Flux;

/**
 * @author starrier
 * @date 2020/12/23
 */
public class BaseSubscriberTest {


    public static void main(String[] args) {

        Flux<Integer> range = Flux.range(1, 10);
        SimpleSubscriberTest<Integer> subscriber = new SimpleSubscriberTest<>();

        // 使用lambda
        range.subscribe(i -> System.out.println("i="+i),
                error -> System.err.println("Error " + error),
                () -> {System.out.println("Done");},
                s -> s.request(10));

        // 使用SampleSubscriber
        range.subscribe(subscriber);
    }
}
