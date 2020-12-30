package org.starrier.sky.ladder.basic.basic;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class ChildBasicB extends BasicClass {

    static {
        System.out.println("Child class static is child-b-static");
    }

    public ChildBasicB(){
        System.out.println("Child class construct is child-b-construct");
    }

    public void hello(){
        System.out.println("Child class hello method is hello-child-b");
    }


}