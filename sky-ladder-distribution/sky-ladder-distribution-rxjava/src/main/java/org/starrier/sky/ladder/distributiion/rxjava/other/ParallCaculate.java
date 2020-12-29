package org.starrier.sky.ladder.distributiion.rxjava.other;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;

/**
 * @author starrier
 * @date 2020/12/4
 */
public class ParallCaculate {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Observable.range(1, 10)
                .groupBy(new Function<Integer, String>() {      //参数：数据，键
                    @Override
                    public String apply(Integer data) {
                        //数据分成两组，偶数组键：key1，奇数组键：key2
                        return data % 2 == 0 ? "key1" : "key2";
                    }
                })
                .flatMap(new Function<GroupedObservable<String, Integer>, ObservableSource<String>>() {
                    //对分的两个组数据进行函数变换，最终我想返回一个发射String的Observable
                    @Override
                    public ObservableSource<String> apply(GroupedObservable<String, Integer> stringIntegerGroupedObservable) throws Exception {
                        //对组中的每一项数据进行函数变换，返回我想要的结果String值
                        return stringIntegerGroupedObservable.map(new Function<Integer, String>() {
                            @Override
                            public String apply(Integer groupData) throws Exception {
                                return groupData.toString();
                            }
                        });
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        }).isDisposed();

        long end = System.currentTimeMillis() - start;
        System.out.println(end);


    }

}
