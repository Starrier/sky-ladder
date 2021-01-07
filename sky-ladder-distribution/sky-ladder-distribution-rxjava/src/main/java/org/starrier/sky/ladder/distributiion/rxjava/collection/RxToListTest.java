package org.starrier.sky.ladder.distributiion.rxjava.collection;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RxToListTest {

    private static String[] strings = new String[]{"one", "two", "three", "four", "five"};

    public static void main(String[] args) {
        valuesToList();
    }

    public static void valuesToList() {

        Observable.fromArray(strings)
                .toList()
                .subscribe(new SingleObserver<List<String>>() {

                    private Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("current dispose " + d);
                        System.out.println("wheathre connect " + d.isDisposed());
                    }

                    @Override
                    public void onSuccess(@NonNull List<String> strings) {
                        if (!CollectionUtils.isEmpty(strings)) {
                            strings.forEach(System.out::println);
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        disposable.dispose();
                    }
                });

    }

}
