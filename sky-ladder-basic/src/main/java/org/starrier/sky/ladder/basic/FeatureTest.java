package org.starrier.sky.ladder.basic;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author starrier
 * @date 2020/12/20
 */
public class FeatureTest {

    Logger LOGGER = LoggerFactory.getLogger(FeatureTest.class);

    public static void main(String[] args) {


    }


    private void future() {
        // 获取一个执行器
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(() -> {
            // 提交之后立即执行
            System.out.println("running");
            Thread.sleep(3000);
            return "complete";
        });
        // 处理其他任务
        try {
            // 调用future.get() 获取执行结果(这居然是一个可能阻塞的调用！)
            System.out.println(future.get());
        } catch (Exception e) {
            LOGGER.error("error", e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private void ComputeFuture() {
        CompletableFuture.supplyAsync(()->{
            // 提交之后立即执行
            System.out.println("running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "complete";

        }).thenAccept(String::toString)// 相当于异步回调
                .whenCompleteAsync((result , throwable) ->{
            System.out.println(result);
        } );
    }
}
