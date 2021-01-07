package org.starrier.sky.ladder.common.basic.entity.factory;


import com.google.common.collect.Lists;
import org.starrier.sky.ladder.common.basic.entity.Student;

import java.util.List;

/**
 * @author starrier
 * @date 2020/12/4
 */
public class StudentFactory {

    public static List<Student> createListA() {

        List<Student> A = Lists.newArrayList();

        A.add(new Student("A", 1));
        A.add(new Student("B", 2));
        A.add(new Student("C", 3));
        A.add(new Student("D", 4));

        return A;

    }

    public static List<Student> createListB() {

        List<Student> B = Lists.newArrayList();

        B.add(new Student("A", 1));
        B.add(new Student("B", 2));
        B.add(new Student("C", 3));

        return B;
    }
}
