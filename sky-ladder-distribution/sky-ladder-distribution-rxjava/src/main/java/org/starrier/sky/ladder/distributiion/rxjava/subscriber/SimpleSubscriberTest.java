package org.starrier.sky.ladder.distributiion.rxjava.subscriber;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author starrier
 * @date 2020/12/23
 */
public class SimpleSubscriberTest<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("----------Subscribed------------");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println("value="+value);
        request(1);
    }

}
