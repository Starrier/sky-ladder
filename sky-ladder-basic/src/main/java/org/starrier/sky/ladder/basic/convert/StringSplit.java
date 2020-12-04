package org.starrier.sky.ladder.basic.convert;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2020/12/3
 */
public class StringSplit {

    public static void main(String[] args) {

        String target  = "11,44,22,33";
        System.out.println(simpleStringSplitToList(target));
        System.out.println(stringSplitToList(target));
    }

    public static List<Integer> stringSplitToList(String target){
        if (StringUtils.isBlank(target)) {
            return new ArrayList<>();
        }

        return Arrays.stream(target.split(","))
                .filter(i -> i.matches("^[\\d]+$"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> simpleStringSplitToList(String str){
        List<Integer> list = new ArrayList<Integer>();
        if (str != null) {
            String[] liststr = str.split(",");
            for (String i : liststr) {
                if (i.matches("^[\\d]+$")) {
                    Integer item = Integer.parseInt(i);
                    list.add(item);
                }
            }
        }
        return list;
    }
}
