package org.starrier.sky.ladder.distributiion.rxjava.other;


import io.reactivex.rxjava3.core.Flowable;

import java.util.ArrayList;

/**
 * @author starrier
 * @date 2020/12/5
 */
public class RxJust {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Flowable.fromArray(arrayList).subscribe(System.out::println).dispose();


    }
}
