package org.starrier.sky.ladder.distributiion.rxjava;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.starrier.sky.ladder.common.basic.entity.Student;
import org.starrier.sky.ladder.common.basic.entity.factory.StudentFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RxTest {

    private Logger LOGGER = LoggerFactory.getLogger(RxTest.class);

    public static void main(String[] args) {
        cacheAbleWithout();
        System.out.println("---------");
        cacheAble();
    }


    public static void cacheAbleWithout(){
         Observable<Integer> work = Observable.fromCallable(()->{
             System.out.println("doing work");
             return 1;
         });
         // without cache
         work.subscribe(System.out::println);
         work.map(integer -> integer*2).subscribe(System.out::println);
    }
    private static void cacheAble(){
        Observable<Integer> work = Observable.fromCallable(()->{
            System.out.println("doing work");
            return 1;
        }).cache();
        // cache
        work.subscribe(System.out::println);
        work.map(integer -> integer*2).subscribe(System.out::println);

    }


}
