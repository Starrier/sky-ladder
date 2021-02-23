package org.starrier.sky.ladder.common.basic.basic;

/**
 * @author starrier
 * @date 2020/11/30
 */
public class ChildBasicA extends BasicClass {

    static {
        System.out.println("Child class static is child-a-static");
    }


    public ChildBasicA() {
        System.out.println("Child class construct is child-a-construct");
    }

    @Override
    public void hello() {
        System.out.println("Child class-a hello method is hello-child-a");
    }
}
