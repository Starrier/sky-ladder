package org.starrier.sky.ladder.basic;

import com.google.common.collect.Lists;
import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2021/1/5
 */
public class StreamForeach {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List<Student> students = StudentFactory.createListA();
        List<String> names = Lists.newArrayListWithExpectedSize(students.size());

        for (Student student : students) {
            // other logic data convert
            names.add(student.getName());
        }

        System.out.println(names);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("------------");

        long startMap = System.currentTimeMillis();
        List<String> namesString = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - startMap);


    }
}
