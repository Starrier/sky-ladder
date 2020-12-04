package org.starrier.sky.ladder.basic.lists;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/2
 */
public class ListDiff {


    public static void main(String[] args) {

        List<Student> listA = createListA();
        List<Student> listB = createListB();

        // 差集
        List<Student> result = listA.stream()
                .filter(item -> !listB.contains(item))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static List<Student> createListA(){

       List<Student> A  = Lists.newArrayList();

       A.add(new Student("A",1));
       A.add(new Student("B",2));
       A.add(new Student("C",3));
       A.add(new Student("D",4));

       return A;

    }

    public static List<Student> createListB(){

        List<Student> B = Lists.newArrayList();

        B.add(new Student("A",1));
        B.add(new Student("B",2));
        B.add(new Student("C",3));

        return B;
    }



}
