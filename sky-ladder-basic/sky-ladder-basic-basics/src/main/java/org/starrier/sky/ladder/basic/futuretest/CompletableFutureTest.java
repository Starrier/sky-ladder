package org.starrier.sky.ladder.basic.futuretest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class CompletableFutureTest {

    private static final Logger LOG = LoggerFactory.getLogger(CompletableFutureTest.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        comboCompletableFuture();

        System.out.println("-------");
        //completeFuture();
    }

    public static void completeFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            LOG.info("hello");
            return "hello-world";
        });
        future.thenRunAsync(() -> LOG.info("world-asyn"));
        future.whenComplete((v, e) -> LOG.info("WhenComplete value: " + v + "WhenComplete exception: " + e));
        LOG.info(future.get() + "");
        LOG.info("time is :" + (System.currentTimeMillis() - startTime));

    }

    public static void comboCompletableFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        LOG.info("time is :" + (System.currentTimeMillis() - startTime));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() ->
        {
            LOG.info("hello");
            return "hello";
        });
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            LOG.info("world");
            return "world";
        });
        CompletableFuture<String> f = future3.thenCombine(future4, (x, y) -> x + "-" + y)
                .whenComplete((v, e) -> LOG.info("WhenComplete value: " + v + "WhenComplete exception: " + e));
        LOG.info(f.get());
    }
}
