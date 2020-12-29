package org.starrier.sky.ladder.distributiion.rxjava.other;


import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
