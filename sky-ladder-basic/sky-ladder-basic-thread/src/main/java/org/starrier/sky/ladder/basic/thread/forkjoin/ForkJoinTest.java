package org.starrier.sky.ladder.basic.thread.forkjoin;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.checkerframework.checker.units.qual.A;
import org.starrier.sky.ladder.common.basic.entity.Student;
import org.starrier.sky.ladder.common.basic.entity.factory.StudentFactory;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class ForkJoinTest {

    public static void main(String[] args) {

        /*long start = System.currentTimeMillis();
        simple();
        long end = System.currentTimeMillis() - start;
        System.out.println(end);

        System.out.println("-------");
        long startForkJoin = System.currentTimeMillis();
        forkJoinForEachTest();

        long endForkJoin = System.currentTimeMillis() - startForkJoin;
        System.out.println(endForkJoin);

        System.out.println("-------");
        long startForkJoinForeach = System.currentTimeMillis();
        List<Integer> list = forkJoinForEachTest();
        System.out.println(list);
        long endForkJoinForeach = System.currentTimeMillis() - startForkJoinForeach;
        System.out.println(endForkJoinForeach);*/

        List<Integer> list = forkJoinTest();
        System.out.println("---------");
        System.out.println(list);

    }


    public static List<Integer> forkJoinTest() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        System.out.println("machine core size is " + Runtime.getRuntime().availableProcessors());
        return forkJoinPool.submit(() ->
                findAge().stream()
                        .peek(student -> System.out.println("current thread name is " + Thread.currentThread().getName() + " and current student age is " + student.getAge()))
                        .map(Student::getAge)
                        .filter(integer -> integer > 2)
                        .collect(Collectors.toList())
        ).fork().join();
    }

    public static List<Integer> forkJoinForEachTest() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        System.out.println("core numbser: " + Runtime.getRuntime().availableProcessors());
        List<Integer> ages = Lists.newArrayList();
        forkJoinPool.submit(() -> findAge().parallelStream()
                .peek(student -> System.out.println("current thread name is " + Thread.currentThread().getName() + " and current student age is " + student.getAge()))
                .forEach(student -> ages.add(student.getAge()))
        ).fork().join();
        return ages;
    }

    public static List<Integer> simple() {
        List<Integer> result = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Student> age = findAge();
            if (CollectionUtils.isNotEmpty(age)) {
                result.addAll(age.stream()
                        .map(Student::getAge)
                        .filter(integer -> integer > 2)
                        .collect(Collectors.toList()));
            }
        }
        return result;
    }

    public static List<Student> findAge() {
        return StudentFactory.createListA();
    }
}
