package org.starrier.sky.ladder.basic.sort;

import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2021/3/24
 */
public class StudentSort {

    public static void main(String[] args) {

        List<Student> listA = StudentFactory.createListA();

        List<Student> collect = listA.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());

        System.out.println(collect);

        List<Student> collect1 = listA.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());

        System.out.println(collect1);
    }
}
