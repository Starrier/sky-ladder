package org.starrier.sky.ladder.basic.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author starrier
 * @date 2021/1/4
 */
public class TypeCompiler {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

        List<String> stringList = new ArrayList<>();
        unsafeAdd(stringList, Integer.valueOf(42));
        System.out.println(stringList);
        System.out.println(stringList.get(0));

    }

    public static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
