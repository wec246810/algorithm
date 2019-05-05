package cn.ysk521.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: yangshangkun
 * @Date: 2019-05-05 10:27
 *
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 **/
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        int preIndex, current;
        for (int i = 0; i < length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 34, 3, 5, 77, 13, 68};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
