package org.starrier.sky.ladder.basic.convert;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class JsonMap {

    public static void main(String[] args) {

        stringJsonToMap("");
    }

    public static Map<Object, Object> stringJsonToMap(String jsonString) {

        Map<Object, Object> parse = (Map<Object, Object>) JSON.parse(jsonString);
        System.out.println(parse.toString());
        return parse;
    }
}
