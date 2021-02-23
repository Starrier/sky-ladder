package org.starrier.sky.ladder.common.basic.basic;

/**
 * @author starrier
 * @date 2020/12/30
 */
public class BasicTest {

    public static void main(String[] args) {

        ChildBasicA childBasicA = new ChildBasicA();

        childBasicA.hello();

        System.out.println("------");

        ChildBasicB childBasicB = new ChildBasicB();
        childBasicB.hello();

    }
}
