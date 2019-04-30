package cn.ysk521.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: yangshangkun
 * @Date: 2019-04-29 14:42
 *
 * 时间复杂度：o(n^2)
 **/
public class BubbleSort {
    private static int[] bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i-1; j++) {
                if (ints[j+1] < ints[j]) {
                    int temp = ints[j+1];
                    ints[j+1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        return ints;
    }


    public static void main(String[] args) {
        int[] array = {2, 5, 34, 3, 5, 77, 13, 68};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }


}
