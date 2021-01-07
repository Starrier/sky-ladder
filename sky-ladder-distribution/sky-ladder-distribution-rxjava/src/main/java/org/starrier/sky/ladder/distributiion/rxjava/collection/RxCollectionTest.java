package org.starrier.sky.ladder.distributiion.rxjava.collection;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author starrier
 * @date 2020/12/22
 */
public class RxCollectionTest {

    public static void main(String[] args) {
        disposable();
    }


    public static void disposable() {

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);

        }).subscribe(new Observer<Integer>() {

            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {

                if (d.isDisposed()) {
                    System.out.println("current status on subscribe before is " + d.isDisposed());
                    disposable = d;
                    compositeDisposable.add(disposable);
                    System.out.println("current status on subscribe after is " + d.isDisposed());
                }

                System.out.println("outside current status on subscribe is " + d.isDisposed());

            }

            @Override
            public void onNext(@NonNull Integer integer) {

                System.out.println("current disposable is " + disposable.isDisposed());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        compositeDisposable.clear();
    }
}
