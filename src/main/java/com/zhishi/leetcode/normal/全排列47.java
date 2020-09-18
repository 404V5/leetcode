package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by songpb on 2020/9/18.
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class 全排列47 {
    private boolean[] vis;

    private List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        全排列47 test = new 全排列47();
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));
    }
}
