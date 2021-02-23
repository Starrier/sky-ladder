package org.starrier.sky.ladder.basic.convert;

import java.util.Arrays;
import java.util.List;

/**
 * @author starrier
 * @date 2020/12/5
 */
public class ListConvvert {


    public static void main(String[] args) {

        boolean test = test();
        System.out.println(test);

    }


    public static boolean test() {
        boolean reverseBool = true;

        List<Integer> idList = Arrays.asList(1, 2, 3);

        List<Integer> list = Arrays.asList(2, 3);

        if (reverseBool) {
            return !list.containsAll(idList);
        } else {
            return idList.stream().anyMatch(x -> list.contains(x));
        }
    }
}
