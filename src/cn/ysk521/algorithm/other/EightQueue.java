package cn.ysk521.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 八皇后问题
 * @author: yangshangkun
 * @Date: 2019-04-30 15:36
 **/
public class EightQueue {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] arr = new int[n];
        putQueen(list, 0, n, arr);
        return list;
    }

    // 尝试放置：递归+回溯
    public static void putQueen(List<List<String>> list, int row, int n, int[] arr) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (arr[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            list.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if (check(arr, row)) {
                putQueen(list, row + 1, n, arr);
            }
        }
    }

    // 检测放置的皇后是否有问题
    public static boolean check(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists.size());
        lists.forEach(list->{
            list.forEach(l->{
                System.out.println(l+"\n");
            });

            System.out.println("------------------");
        });
    }
}
