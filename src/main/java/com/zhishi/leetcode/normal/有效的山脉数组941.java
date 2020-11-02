package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/11/3.
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class 有效的山脉数组941 {
    /**
     * 方法一：线性扫描
     */
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }
}
