package org.starrier.sky.ladder.basic.lists;

import com.google.common.collect.Lists;
import org.starrier.sky.ladder.basic.entity.Student;
import org.starrier.sky.ladder.basic.entity.factory.StudentFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/2
 */
public class ListDiff {


    public static void main(String[] args) {

        List<Student> listA = StudentFactory.createListA();
        List<Student> listB = StudentFactory.createListB();

        // 差集
        List<Student> result = listA.stream()
                .filter(item -> !listB.contains(item))
                .collect(Collectors.toList());

        System.out.println(result);
    }





}
