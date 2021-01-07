package org.starrier.sky.ladder.basic.basic;

/**
 * @author starrier
 * @date 2020/11/30
 */
public class BasicClass {

    static {
        System.out.println("Basic class static is basic-static ");
    }

    public BasicClass() {
        System.out.println("Basic class construct is basic-construct");
    }

    public void hello() {
        System.out.println("Basic class hello method is hello-basic");
    }
}
