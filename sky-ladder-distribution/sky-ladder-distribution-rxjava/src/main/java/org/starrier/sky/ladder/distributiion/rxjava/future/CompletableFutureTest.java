package org.starrier.sky.ladder.distributiion.rxjava.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.starrier.sky.ladder.common.basic.entity.Student;
import org.starrier.sky.ladder.common.basic.entity.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/23
 */
public class CompletableFutureTest {

    private static final Logger LOG = LoggerFactory.getLogger(CompletableFutureTest.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //completeFuture();
        //comboCompletableFuture();
        comboObjectCompletableFuture();
    }

    public static void completeFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // case1: supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            LOG.info("Run supplyAsync.");
            return "Return result of Supply Async";
        });

        // case2: thenRun，与supplyAsync同线程
        future.thenRun(new Runnable() {

            @Override
            public void run() {
                LOG.info("Run action.");
            }
        });

        // case2: thenRunAsync，另启动线程执行
        future.thenRunAsync(new Runnable() {

            @Override
            public void run() {
                LOG.info("Run async action.");
            }
        });

        // 主动触发Complete结束方法
        // future.complete("Manual complete value.");
        future.whenComplete((v, e) -> {
            LOG.info("WhenComplete value: " + v);
            LOG.info("WhenComplete exception: " + e);
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            LOG.info("Return result of Run Async.");
        });

        LOG.info(future2.get() + "");
        LOG.info("time is :" + (System.currentTimeMillis() - startTime));

    }

    public static void comboCompletableFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        LOG.info("time is :" + (System.currentTimeMillis() - startTime));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> f = future3.thenCombine(future4, (x, y) -> x + "-" + y);
        LOG.info(f.get());
    }

    public static void comboObjectCompletableFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        LOG.info("time is :" + (System.currentTimeMillis() - startTime));
        CompletableFuture<List<Student>> future3 = CompletableFuture.supplyAsync(StudentFactory::createListA);
        CompletableFuture<List<Student>> future4 = CompletableFuture.supplyAsync(StudentFactory::createListB);
        CompletableFuture<List<Student>> objectCompletableFuture = future3.thenCombine(future4, (x, y) -> {
            if (CollectionUtils.isEmpty(x) || CollectionUtils.isEmpty(y)) {
                return CollectionUtils.isEmpty(x) ? y : x;
            }
            List<Student> result = new ArrayList<>();
            result.addAll(x);
            result.addAll(y);
            return result.stream().distinct().collect(Collectors.toList());
        }).toCompletableFuture();
        System.out.println("result is " + objectCompletableFuture.get());
    }
}
