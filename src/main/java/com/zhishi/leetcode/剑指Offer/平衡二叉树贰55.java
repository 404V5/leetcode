package com.zhishi.leetcode.剑指Offer;


/**
 * Created by songpb on 2020/9/12.
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class 平衡二叉树贰55 {
    /**
     * 方法一 后序遍历 + 剪枝 （从底至顶）
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 方法二 先序遍历 + 判断深度 （从顶至底）
     */
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int depth(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(depth(root.left), depth(root.right)) + 1;
//    }

}
