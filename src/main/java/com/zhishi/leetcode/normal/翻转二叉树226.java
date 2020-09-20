package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

/**
 * Created by songpb on 2020/9/16.
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class 翻转二叉树226 {
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        翻转二叉树226 test= new 翻转二叉树226();
    }
}
