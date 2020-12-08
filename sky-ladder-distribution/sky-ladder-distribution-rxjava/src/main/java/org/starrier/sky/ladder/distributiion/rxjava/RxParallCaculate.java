package org.starrier.sky.ladder.distributiion.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author starrier
 * @date 2020/12/4
 */
public class RxParallCaculate {


    public static void main(String[] args) {
        System.out.println(rxjavaParallel());
    }

    @SuppressWarnings("unchecked")
    public static List<Integer> rxjavaParallel() {

        final List<Integer> result = new ArrayList<Integer>();


        ParallelFlowable<Integer> parallelFlowable1 = Flowable.range(1, 10).parallel();


        Disposable subscribe = parallelFlowable1.runOn(Schedulers.io())
                .map(o->{
                        System.out.println("scheduler " + o);
                        result.add(Integer.valueOf(o.toString()));
                        return String.valueOf(o);
                    }
                )

                .sequential()
                .subscribe(o -> {
                    System.out.println("Consumer  " + o);
                    if (o != null) {
                        result.add(Integer.valueOf(o));
                    }

                });
        return result;

    }
}
