package org.starrier.sky.ladder.basic.strings;


import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public static List<String> getParamsFromURL(String url) {

        return Stream.of(url)
                .filter(StringUtils::isNoneBlank)
                .map(x -> x.split("&"))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("filters="))
                .map(s -> s.split("="))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .filter(s -> s.startsWith("[") && s.endsWith("]"))
                .map(Objects::nonNull)
                .map(Objects::toString)
                .map(s -> s.replace("[", "").replace("]", ""))
                .collect(Collectors.toList());

    }

}
