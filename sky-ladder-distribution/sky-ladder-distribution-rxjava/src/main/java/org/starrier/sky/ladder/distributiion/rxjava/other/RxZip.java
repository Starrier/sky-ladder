package org.starrier.sky.ladder.distributiion.rxjava.other;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author starrier
 * @date 2020/12/5
 */
public class RxZip {

    public static void main(String[] args) {

        Observable<Integer> integerObservable = zipSource1();
        Observable<String> stringObservable = zipSource2();
        Disposable disposable = zipSourceResult(integerObservable, stringObservable);
        System.out.println(disposable);
    }

    public static Observable<Integer> zipSource1() {
        Observable<Integer> integerObservable1 = Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                for (int i = 0; i < 10; i++) {
                    emitter.onNext(i);
                    System.out.println("Integer --- " + i);
                }
            }
        }).subscribeOn(Schedulers.io());

        return integerObservable1;
    }


    public static Observable<String> zipSource2() {
        Observable<String> integerObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                for (int i = 0; i < 10; i++) {
                    emitter.onNext("A".concat(String.valueOf(i)));
                    System.out.println("String ----" + i);
                }
            }
        }).subscribeOn(Schedulers.io());
        return integerObservable;
    }

    public static Disposable zipSourceResult(Observable<Integer> source1, Observable<String> source2) {
        Disposable disposable = Observable.zip(source1, source2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String string) throws Throwable {
                return integer + string;
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                System.out.println(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                System.out.println(throwable);
            }
        });

        return disposable;
    }
}
