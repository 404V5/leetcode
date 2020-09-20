package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/20.
 * https://leetcode-cn.com/problems/subsets/
 */
public class 子集78 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 方法一：迭代法实现子集枚举
     */
//    public List<List<Integer>> subsets(int[] nums) {
//        int n = nums.length;
//        for (int mask = 0; mask < (1 << n); ++mask) {
//            t.clear();
//            for (int i = 0; i < n; ++i) {
//                if ((mask & (1 << i)) != 0) {
//                    t.add(nums[i]);
//                }
//            }
//            ans.add(new ArrayList<Integer>(t));
//        }
//        return ans;
//    }

    /**
     * 方法二：递归法实现子集枚举
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        子集78 test= new 子集78();
        System.out.println(test.subsets(new int[] {1,2,3}));
    }

}
