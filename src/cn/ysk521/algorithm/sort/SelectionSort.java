package cn.ysk521.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: yangshangkun
 * @Date: 2019-05-05 10:09
 * <p>
 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 34, 3, 5, 77, 13, 68};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int length = arr.length;
        int min, temp;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i; j < length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
