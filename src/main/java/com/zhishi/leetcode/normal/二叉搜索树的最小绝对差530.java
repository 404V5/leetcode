package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

/**
 * Created by songpb on 2020/10/12.
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class 二叉搜索树的最小绝对差530 {
    /**
     * 方法一：中序遍历
     */
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
