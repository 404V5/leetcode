package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by songpb on 2020/9/19.
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class 左叶子之和404 {
    /**
     * 方法一：深度优先搜索
     */
//    public int sumOfLeftLeaves(TreeNode root) {
//        return root != null ? dfs(root) : 0;
//    }
//
//    public int dfs(TreeNode node) {
//        int ans = 0;
//        if (node.left != null) {
//            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
//        }
//        if (node.right != null && !isLeafNode(node.right)) {
//            ans += dfs(node.right);
//        }
//        return ans;
//    }
//
//    public boolean isLeafNode(TreeNode node) {
//        return node.left == null && node.right == null;
//    }
    /**
     * 方法二: 广度优先遍历
     */

    private int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
