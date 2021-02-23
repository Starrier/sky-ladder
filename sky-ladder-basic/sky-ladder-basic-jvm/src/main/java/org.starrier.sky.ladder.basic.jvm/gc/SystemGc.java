package org.starrier.sky.ladder.basic.jvm.gc;

public class SystemGc {

    public static void main(String[] args) {
        System.gc();
        Runtime.getRuntime().gc();
    }
}
