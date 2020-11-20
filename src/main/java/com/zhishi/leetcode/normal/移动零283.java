package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/11/20.
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class 移动零283 {
    /**
     * 方法一：双指针
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
