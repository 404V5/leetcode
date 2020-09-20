package com.zhishi.leetcode.normal;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by songpb on 2020/9/11.
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class 组合总和叁216 {
    private List<List<Integer>> ans = new ArrayList<>();
    //尽量不要使用遗留的Stack，Deque完成可以实现Stack功能
    private Deque<Integer> path = new ArrayDeque<>();
    private List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1);
        return ans;
    }

    private void dfs(int k,int n,int start){
        if(k<0||n<0) return; //剪枝
        //刚好K个数，刚好递减成0(说明这k个数字累加和刚好是n)
        if(k==0 && n==0){
            if(!path.isEmpty())
                ans.add(new ArrayList<>(path));
            return;
        }
        // 从start开始，到9的范围，然后是递归分支（选，不选）记得恢复状态
        for(int i=start;i<10;i++){
            path.push(i);
            dfs(k-1,n-i,++start);
            path.pop();
        }
    }
    public static void main(String[] args) {
        组合总和叁216 test= new 组合总和叁216();
        System.out.println(test.combinationSum3(3,8));
    }
}
