package org.starrier.sky.ladder.basic;

/**
 * @author starrier
 * @date 2020/11/30
 */
public class ChildBasicA extends BasicClass {

    static {
        System.out.println("Child class static is c");
    }


    public ChildBasicA() {
        System.out.println("Child class construct is d");
    }
}
