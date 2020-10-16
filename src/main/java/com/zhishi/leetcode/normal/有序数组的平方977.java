package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/16.
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class 有序数组的平方977 {
    /**
     * 方法一：直接排序
     */
//    public int[] sortedSquares(int[] A) {
//        int[] ans = new int[A.length];
//        for (int i = 0; i < A.length; ++i) {
//            ans[i] = A[i] * A[i];
//        }
//        Arrays.sort(ans);
//        return ans;
//    }
    /**
     * 方法二：双指针
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }
}
