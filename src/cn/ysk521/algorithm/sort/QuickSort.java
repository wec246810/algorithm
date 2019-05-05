package cn.ysk521.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: yangshangkun
 * @Date: 2019-04-29 14:59
 * <p>
 * 时间复杂度：o(nlogn)，最差为o(n^2)
 * 思想：分治法,分治思想。
 * <p>
 * 分治法：就是将一个复杂的问题拆解为n个简单的问题进行解决，通常和递归配合使用。
 **/
public class QuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex大于endIndex的时候。
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {

        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 34, 3, 5, 77, 13, 68};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
