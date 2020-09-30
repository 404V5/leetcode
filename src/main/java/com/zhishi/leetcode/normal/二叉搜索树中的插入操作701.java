package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

/**
 * Created by songpb on 2020/9/30.
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class 二叉搜索树中的插入操作701 {
    /**
     * 方法一：模拟
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
