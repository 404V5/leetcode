package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/9.
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class 组合总和39 {
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine= new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    private void dfs(int[] candidates ,int target ,List<List<Integer>> ans,List<Integer> combine,int idx){
        if(idx == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        //直接跳过
        dfs(candidates,target,ans,combine,idx+1);
        //选择当前数
        if(target -candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            combine.remove(combine.size()-1);
        }
    }

    public static void main(String[] args) {
        组合总和39 test= new 组合总和39();
        System.out.println(test.combinationSum(new int[]{2,3,5},8));
    }
}
