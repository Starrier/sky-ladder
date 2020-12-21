package org.starrier.sky.ladder.distributiion.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
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
public class FilterStream {

    public static void main(String[] args) {
        observableCall();
    }

    public static void observableCall() {

        List<Student> students = StudentFactory.createListA();

        // 及早求值
        List<Integer> filterResultInTime = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .map(Student::getAge)
                .collect(Collectors.toList());
        System.out.println(filterResultInTime.get(0));
        System.out.println(filterResultInTime.get(0));

        // 惰性求值
        Stream<Integer> integerStream = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .map(Student::getAge);
        System.out.println(integerStream.findFirst());
        System.out.println(integerStream.findFirst());


        Single<List<Object>> collect = Observable.just(students)
                .map(new Function<List<Student>, Object>() {
                    @Override
                    public Object apply(List<Student> students) throws Throwable {
                        return students.stream().map(Student::getAge);
                    }
                })
                .sorted()
                .cache()
                .collect(Collectors.toList());

        Single<List<Object>> collectToList = Observable.just(students)

                .map(new Function<List<Student>, Object>() {
                    @Override
                    public Object apply(List<Student> students) throws Throwable {
                        return students.stream().map(Student::getAge);
                    }
                })
                .sorted()
                .cache()
                .toList();
    }

}
