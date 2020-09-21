package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

/**
 * Created by songpb on 2020/9/21.
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class 把二叉搜索树转换为累加树538 {
    int sum = 0;

    /**
     * 方法一：反序中序遍历
     */
//    public TreeNode convertBST(TreeNode root) {
//        if (root != null) {
//            convertBST(root.right);
//            sum += root.val;
//            root.val = sum;
//            convertBST(root.left);
//        }
//        return root;
//    }

    /**
     * 方法二：Morris 遍历
     */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    public static void main(String[] args) {
        把二叉搜索树转换为累加树538 test = new 把二叉搜索树转换为累加树538();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(test.convertBST(root));
    }
}
