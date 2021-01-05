package org.starrier.sky.ladder.basic.basic;

import org.starrier.sky.ladder.basic.entity.Student;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class ClassTypeConvert {

    public static void main(String[] args) {

        String a = null;
        System.out.println((Object)a);

        Integer b = null;
        System.out.println((Object)b);


        Student c = null;
        System.out.println((Object)c);

        int d = (Integer)b;
        System.out.println(d);
    }
}
