package com.zhishi.leetcode.normal;

import java.util.Arrays;

/**
 * Created by songpb on 2020/11/30.
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class 三角形的最大周长976 {
    /**
     * 方法一：贪心 + 排序
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
