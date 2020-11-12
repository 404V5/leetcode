package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/11/12.
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class 按奇偶排序数组贰922 {
    /**
     * 方法一： 两次遍历
     */
//    public int[] sortArrayByParityII(int[] A) {
//        int n = A.length;
//        int[] ans = new int[n];
//
//        int i = 0;
//        for (int x : A) {
//            if (x % 2 == 0) {
//                ans[i] = x;
//                i += 2;
//            }
//        }
//        i = 1;
//        for (int x : A) {
//            if (x % 2 == 1) {
//                ans[i] = x;
//                i += 2;
//            }
//        }
//        return ans;
//    }

    /**
     * 方法二： 双指针
     */
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
