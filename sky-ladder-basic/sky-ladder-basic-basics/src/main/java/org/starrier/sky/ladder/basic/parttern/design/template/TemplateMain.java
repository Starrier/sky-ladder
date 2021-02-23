package org.starrier.sky.ladder.basic.parttern.design.template;

/**
 * @author starrier
 * @date 2020/11/28
 */
public class TemplateMain {

    public static void main(String[] args) {

        TemplateChild2 templateChild2 = new TemplateChild2();
        templateChild2.bond(new TemplateAbstractMethod() {
            @Override
            protected void abstractMethod() {
                System.out.println("test");
            }
        });
        System.out.println("");
        TemplateChild templateChild = new TemplateChild();
        templateChild.abstractMethod();
    }
}
