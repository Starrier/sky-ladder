package org.starrier.sky.ladder.basic.optional;

import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2021/1/5
 */
public class OptionalTest {

    public static void main(String[] args) {

        List<Student> studentList = StudentFactory.createListA();

        List<Student> students = new ArrayList<>();

        //1
        Integer integer = Optional.ofNullable(
                studentList
                        .stream()
                        .map(Student::getAge)
                        .collect(Collectors.toList())
                        .get(0))
                .orElse(null);

        System.out.println(integer);

        // Exception
        Integer testFilter = students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAge)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(testFilter);

        // Exception
        Integer testNull = Optional.ofNullable(
                students
                        .stream()
                        .map(Student::getAge)
                        .collect(Collectors.toList())
                        .get(0))
                .orElseGet(null);

        System.out.println(testNull);

    }
}
