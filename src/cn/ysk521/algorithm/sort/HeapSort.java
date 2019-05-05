package cn.ysk521.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 堆排序
 * @author: yangshangkun
 * @Date: 2019-05-05 09:54
 **/
public class HeapSort {

    public static void heapSort(int[] array) {
        //初始建堆，array[0]为第一趟值最大的元素
        array = buildMaxHeap(array);
//        for (int i = array.length - 1; i >= 1; i--) {
//            int temp = array[0];  //将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
//            array[0] = array[i];
//            array[i] = temp;
//            adjustHeap1(array, 0, i);  //整理，将剩余的元素整理成大顶堆
//        }
    }

    /**
     * 自下而上构建大顶堆：将array看成完全二叉树的顺序存储结构
     *
     * @param array
     * @return
     */
    private static int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            System.out.println("i :" + i);
            adjustHeap1(array, i, array.length);
        }
        return array;

    }

    //自上而下调整大顶堆（非递归）
    private static void adjustHeap1(int[] array, int k, int length) {
        System.out.println("调整堆之前 array：" + Arrays.toString(array) + " k: " + k + " length: " + length);
        //堆顶节点
        int temp = array[k];
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k + 1; i <= length - 1; i = 2 * i + 1) {
            //如果左孩子小于右孩子
            if (i + 1 < length && array[i] < array[i + 1]) {
                //则取右孩子节点的下标
                i++;
            }
            //堆顶节点 >=左右孩子中较大者，调整结束
            if (temp >= array[i]) {
                break;
            } else {
                /*
                根节点 < 左右子女中关键字较大者
                将左右子结点中较大值array[i]调整到双亲节点上
                【关键】修改k值，以便继续向下调整
                 */
                array[k] = array[i];
                k = i;
            }
        }
        //被堆顶结点的值放人最终位置
        array[k] = temp;
        System.out.println("调整堆之后 array：" + Arrays.toString(array) + " k: " + k + " length: " + length);
    }

    //自上而下调整大顶堆（递归）
    private static void adjustHeap2(int[] array, int k, int length) {
        int k1 = 2 * k + 1;
        if (k1 < length - 1 && array[k1] < array[k1 + 1]) {
            k1++;
        }
        if (k1 > length - 1 || array[k] >= array[k1]) {
            return;
        } else {
            int temp = array[k];  //将堆顶元素和左右子结点中较大节点交换
            array[k] = array[k1];
            array[k1] = temp;
            adjustHeap2(array, k1, length);
        }
    }


    public static void main(String[] args) {
        int[] array = {8, 5, 34, 3, 5, 77, 13, 68};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
