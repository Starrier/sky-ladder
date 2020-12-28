package org.starrier.sky.ladder.basic.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class SumLambda {

    public static void main(String[] args) {
        Integer sum = sum(1, 2);
        System.out.println(sum);
    }

    public static Integer sum(Integer a,Integer b){
        BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {

            @Override
            public BiFunction andThen(Function after) {
                return null;
            }

            @Override
            public Integer apply(Integer o, Integer o2) {
                return o + o2;
            }
        };

        return biFunction.apply(a, b);
    }
}
