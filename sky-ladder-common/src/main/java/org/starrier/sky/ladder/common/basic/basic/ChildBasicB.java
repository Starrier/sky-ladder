package org.starrier.sky.ladder.common.basic.basic;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class ChildBasicB extends BasicClass {

    static {
        System.out.println("Child class static is child-b-static");
    }

    public ChildBasicB() {
        System.out.println("Child class construct is child-b-construct");
    }

    public static void main(String[] args) {

        String a = null;

        System.out.println((Object) a);
        System.out.println((Object) null);
    }

    public void hello() {
        System.out.println("Child class hello method is hello-child-b");
    }

}
