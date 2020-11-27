package org.starrier.sky.ladder.algorithm;

import java.util.Arrays;

/**
 * 经典排序  - 冒泡排序
 * @author starrier
 * @date 2020/11/27
 */
public class BubbleSortTest {

    public static void main(String[] args) {

        int[] a = {1, 5, 4, 55, 4, 77};

        System.out.println(Arrays.toString(bubbleSort(a)));
    }


    public static int[] bubbleSort(int [] nums){

        if(nums == null || nums.length <= 1){
            return nums;
        }

        for (int i = 0; i <nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if(nums[j]>nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] =temp;
                }
            }
        }
        return nums;
    }
}
