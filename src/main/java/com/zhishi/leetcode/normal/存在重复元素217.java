package com.zhishi.leetcode.normal;

import java.util.Arrays;

/**
 * Created by songpb on 2020/12/13.
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class 存在重复元素217 {
    /**
     * 方法一：排序
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：哈希表
     */
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<Integer>();
//        for (int x : nums) {
//            if (!set.add(x)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
