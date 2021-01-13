package org.starrier.sky.ladder.basic.stream;

import org.starrier.sky.ladder.basic.entity.Student;
import sun.jvm.hotspot.opto.HaltNode;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author starrier
 * @date 2021/1/7
 */
public class Maps {


    public static void map(){

        Student a = new Student("hello",1);
        Map<String,Student> map = new HashMap<>();
        map.put(a.getName(),a);

        Student b = new Student("hello",2);
        Student a1 = new Student("world",3);

        Map<String,Student> map1 = new HashMap<>();
        map1.put(b.getName(),b);
        map1.put(a1.getName(),a1);

        map.putAll(map1);

        System.out.println(map.toString());

    }

    public void map1(){


    }

    public static void main(String[] args) {

        map();
        long from = LocalDateTime.now().minusDays(Long.parseLong("7")).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        long to = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("from " + from);
        System.out.println("-------");
        System.out.println("to    "+ to);
    }
}
