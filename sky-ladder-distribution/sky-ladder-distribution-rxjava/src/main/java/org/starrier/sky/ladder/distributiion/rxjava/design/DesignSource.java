package org.starrier.sky.ladder.distributiion.rxjava.design;

/**
 * @author starrier
 * @date 2020/12/21
 */
public class DesignSource {

    public static void main(String[] args) {

    }

    private static void commandRelation(){
        int a=1;
        int b=a+1;
        System.out.print("b="+b);    //  b=2
        a=10;
        System.out.print("b="+b);     //  b=2
    }

    /*private static void reactivexRelation(){
        int a=1;
        int b <= a+1;   // <= 符号只是表示a和b之间关系的操作符
        System.out.print("b="+b) ;   //  b=2
        a=10;
        System.out.print("b="+b) ;   //  b=11
    }*/
}
