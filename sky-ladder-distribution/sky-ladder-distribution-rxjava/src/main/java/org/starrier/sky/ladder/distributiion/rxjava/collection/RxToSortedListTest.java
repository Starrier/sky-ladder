package org.starrier.sky.ladder.distributiion.rxjava.collection;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.springframework.util.CollectionUtils;
import org.starrier.sky.ladder.common.basic.entity.Student;
import org.starrier.sky.ladder.common.basic.entity.factory.StudentFactory;

import java.util.Comparator;
import java.util.List;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class RxToSortedListTest {

    private static String[] strings = new String[]{"one", "two", "three", "four", "five"};


    public static void main(String[] args) {
        toSortedListTest();
        System.out.println("-----------");
        sortedToListCustomer();
    }


    public static void toSortedListTest() {
        Observable.fromArray(strings)
                .toSortedList()
                .subscribe(new SingleObserver<List<String>>() {
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("connect status" + d.isDisposed());
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

    public static void sortedToListCustomer() {

        List<Student> students = StudentFactory.createListA();

        Observable.fromIterable(students)
                .toSortedList(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {

                        if (o1.getAge() > o2.getAge()) {
                            return 1;
                        } else if (o1.getAge() < o2.getAge()) {
                            return -1;
                        }
                        return 0;
                        // return o1.getName().compareTo(o2.getName());
                    }
                })
                .subscribe(new SingleObserver<List<Student>>() {
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("connect status " + d.isDisposed());
                    }

                    @Override
                    public void onSuccess(@NonNull List<Student> students) {
                        if (!CollectionUtils.isEmpty(students)) {
                            students.forEach(student -> System.out.println(student.toString()));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        disposable.dispose();
                    }
                });
    }

}
