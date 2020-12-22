package org.starrier.sky.ladder.distributiion.rxjava.flux;

import reactor.core.publisher.Flux;

/**
 * @author starrier
 * @date 2020/12/5
 */
public class FluxTest {

    public static void main(String[] args) {

    }

    public static void fluxArray(){

        String[] strings = new String[]{"one","two","three"};
        Flux.fromArray(strings).collectList();

    }

}
