package org.starrier.sky.ladder.distributiion.rxjava.future;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author starrier
 * @date 2020/12/23
 */
public class ListenableFutureTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenableFutureTest.class);

    //线程池中线程个数
    private static final int POOL_SIZE = 50;
    //带有回调机制的线程池
    private static final ListeningExecutorService service = MoreExecutors
            .listeningDecorator(Executors.newFixedThreadPool(POOL_SIZE));

    public static void main(String[] args) {

    }

    public static void listenableFutureTest() {


        List<String> listValues = Collections.synchronizedList(new ArrayList<>());


        List<ListenableFuture<String>> listenableFutures = new ArrayList<ListenableFuture<String>>();
        IntStream.range(1, 9).forEach(i -> {
            final int index = i;
            if (i == 9) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ListenableFuture<String> listenableFuture = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    long time = System.currentTimeMillis();
                    LOGGER.info("Finishing sleeping task{}: {}", index, time);
                    return String.valueOf(time);
                }
            });
        });



    }
}
