package org.starrier.sky.ladder.distributiion.rxjava.retry;

import reactor.core.publisher.Flux;

/**
 * @author starrier
 * @date 2020/12/22
 */
public class RxRetry {

    public static void main(String[] args) throws InterruptedException {
        retry();
    }

    public static void retry() throws InterruptedException {
        Flux.range(1, 6)
                .map(i -> 10 / (3 - i))
                .retry(1)
                .subscribe(System.out::println, System.err::println);
        Thread.sleep(100);  // 确保序列执行完
    }
}
