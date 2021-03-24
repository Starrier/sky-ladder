package org.starrier.sky.ladder.basic.lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author starrier
 * @date 2021/1/22
 */
public class ListStream {

    public static void main(String[] args) {
        String str = "competitors_cnt:4,competitor_details:(神州租车,一嗨租车,租租车,悟空租车)";

        System.out.println(str.substring(str.indexOf("(")+1,str.indexOf(")")));
    }

    public static Object getList(String s){
        List<String> collect = Stream
                .of(s)
                .map(target -> target.split(","))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                //.filter(filterCompetitiorDetails-> filterCompetitiorDetails.startsWith("competitor_details"))
                .collect(Collectors.toList());
        System.out.println("collect" + collect);
        System.out.println("----------");
        return collect;
    }


    public static String trimFirstAndLastChar(String str, String element) {

        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;

        do {
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);

        return str;
    }
}
