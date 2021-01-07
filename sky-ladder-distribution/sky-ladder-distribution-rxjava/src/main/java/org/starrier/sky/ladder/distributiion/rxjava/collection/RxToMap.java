package org.starrier.sky.ladder.distributiion.rxjava.collection;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.starrier.sky.ladder.common.basic.entity.Student;
import org.starrier.sky.ladder.common.basic.entity.factory.StudentFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RxToMap {


    public static void main(String[] args) {
        rxToMap();
    }

    public static void rxToMap() {

        List<Student> students = StudentFactory.createListA();

        Observable.fromIterable(students)
                .toMap(Student::getName)
                .subscribe(new SingleObserver<Map<String, Student>>() {

                    private Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("connect status " + d.isDisposed());
                    }

                    @Override
                    public void onSuccess(@NonNull Map<String, Student> stringStudentMap) {
                        System.out.println(stringStudentMap.toString());
                        System.out.println("-----");
                        Set<Map.Entry<String, Student>> entrySet = stringStudentMap.entrySet();
                        for (Map.Entry<String, Student> entry : entrySet) {
                            System.out.println(entry.getKey() + "=========" + entry.getValue());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        disposable.dispose();
                    }
                });
    }
}
