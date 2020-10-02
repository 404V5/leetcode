package com.zhishi.leetcode.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by songpb on 2020/10/3.
 * https://leetcode-cn.com/problems/two-sum/
 */
public class 两数之和1 {
    /**
     * 方法一：暴力枚举
     */
//    public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            for (int j = i + 1; j < n; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];
//    }
    /**
     * 方法二：哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
