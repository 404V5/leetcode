package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/26.
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class 有多少小于当前数字的数字1365 {
    /**
     * 方法一：暴力
     */
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int n = nums.length;
//        int[] ret = new int[n];
//        for (int i = 0; i < n; i++) {
//            int cnt = 0;
//            for (int j = 0; j < n; j++) {
//                if (nums[j] < nums[i]) {
//                    cnt++;
//                }
//            }
//            ret[i] = cnt;
//        }
//        return ret;
//    }
    /**
     * 方法二：快速排序
     */
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int n = nums.length;
//        int[][] data = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            data[i][0] = nums[i];
//            data[i][1] = i;
//        }
//        Arrays.sort(data, new Comparator<int[]>() {
//            public int compare(int[] data1, int[] data2) {
//                return data1[0] - data2[0];
//            }
//        });
//
//        int[] ret = new int[n];
//        int prev = -1;
//        for (int i = 0; i < n; i++) {
//            if (prev == -1 || data[i][0] != data[i - 1][0]) {
//                prev = i;
//            }
//            ret[data[i][1]] = prev;
//        }
//        return ret;
//    }
    /**
     * 方法三：计数排序
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }
}
