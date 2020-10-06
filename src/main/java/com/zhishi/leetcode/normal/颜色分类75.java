package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/7.
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
 */
public class 颜色分类75 {
    /**
     * 方法一：单指针
     */
//    public void sortColors(int[] nums) {
//        int n = nums.length;
//        int ptr = 0;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[ptr];
//                nums[ptr] = temp;
//                ++ptr;
//            }
//        }
//        for (int i = ptr; i < n; ++i) {
//            if (nums[i] == 1) {
//                int temp = nums[i];
//                nums[i] = nums[ptr];
//                nums[ptr] = temp;
//                ++ptr;
//            }
//        }
//    }
    /**
     * 方法二：双指针
     */
//    public void sortColors(int[] nums) {
//        int n = nums.length;
//        int p0 = 0, p1 = 0;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] == 1) {
//                int temp = nums[i];
//                nums[i] = nums[p1];
//                nums[p1] = temp;
//                ++p1;
//            } else if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[p0];
//                nums[p0] = temp;
//                if (p0 < p1) {
//                    temp = nums[i];
//                    nums[i] = nums[p1];
//                    nums[p1] = temp;
//                }
//                ++p0;
//                ++p1;
//            }
//        }
//    }
    /**
     * 方法三：双指针
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
