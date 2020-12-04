package org.starrier.sky.ladder.basic.parallel;

import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.List;

/**
 * @author starrier
 * @date 2020/12/4
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {

        List<Student> listA = StudentFactory.createListA();
        List<Student> listB = StudentFactory.createListB();
    }

    private static void parallelStream(List<Student> students) {
        students.parallelStream()
                .map(new java.util.function.Function<Student, String>() {
                    @Override
                    public String apply(Student s) {
                        return s.getName();
                    }
                }).forEach(new java.util.function.Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        });
    }
}
