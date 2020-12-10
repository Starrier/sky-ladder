package org.starrier.sky.ladder.basic.strings;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Splitter;

import org.apache.commons.collections4.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author starrier
 * @date 2020/12/8
 */
public class Soplit {


    public static String getParam(String url, String name) {
        String params = url.substring(url.indexOf("?") + 1);
        Map<String, String> split = Splitter.on("&").withKeyValueSeparator("=").split(params);
        return split.get(name);
    }

    public static String getParamsFromURL(String url){

        String  result = "";
        String[] split = url.split("&");
        List<String[]> collect = Arrays.stream(split)
                .filter(s -> s.startsWith("filters="))

                .map(s -> s.split("="))
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(collect)){
            String[] strings = collect.get(0);
            List<String> collect1 = Arrays.stream(strings)
                    .filter(s -> s.startsWith("[") && s.endsWith("]"))
                    .collect(Collectors.toList());

            if(CollectionUtils.isNotEmpty(collect1)){
                result = collect1.get(0).replace("[","").replace("]","");
            }

        }
        return result;
    }


}
