package org.starrier.sky.ladder.basic.url;

import com.google.common.base.Splitter;

import java.util.Map;

/**
 * @author starrier
 * @date 2020/12/8
 */
public class Url {


    public static String getSpecifiedParamFromURL(String url, String name) {
        String params = url.substring(url.indexOf("?") + 1);
        Map<String, String> split = Splitter.on("&").withKeyValueSeparator("=").split(params);
        return split.get(name);
    }
}
