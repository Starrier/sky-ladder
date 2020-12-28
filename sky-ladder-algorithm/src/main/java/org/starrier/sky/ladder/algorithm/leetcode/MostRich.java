package org.starrier.sky.ladder.algorithm.leetcode;

/**
 * @author starrier
 * @date 2020/12/26
 */
public class MostRich {

    public static void main(String[] args) {

    }

    public static int resolveOne(int[][] accounts) {
        int max = -1;
        for (int i = 0; i <= accounts.length; i++) {
            for (int j = 0; j <= accounts[i].length; j++) {
                if (accounts[i][j] > max) {
                    max = accounts[j][j];
                }
            }
        }
        return max;
    }

}
