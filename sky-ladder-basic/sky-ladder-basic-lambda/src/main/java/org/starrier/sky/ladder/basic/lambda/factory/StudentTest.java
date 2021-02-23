package org.starrier.sky.ladder.basic.lambda.factory;

import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class StudentTest {

    public static void main(String[] args) {

        List<Student> listB = StudentFactory.createListB();

        List<Student> listA = StudentFactory.createListA();

        List<Student> result = new ArrayList<>();
        result.addAll(listA);
        result.addAll(listB);

        long startTimeParaller = System.currentTimeMillis();

        List<Integer> list = StudentFactoryConvert.studentsConvertParaller(result);

        System.out.println(System.currentTimeMillis() - startTimeParaller);

        System.out.println("----------");

        long startSimple = System.currentTimeMillis();
        List<Integer> list1 = StudentFactoryConvert.studentsConvert(result);
        System.out.println(System.currentTimeMillis() - startSimple);

        System.out.println();
    }
}
