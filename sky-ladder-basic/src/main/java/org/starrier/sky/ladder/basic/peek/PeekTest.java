package org.starrier.sky.ladder.basic.peek;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class PeekTest {

    public static void main(String[] args) {

        peekApiTest();
    }

    public static void peekApiTest() {
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}
