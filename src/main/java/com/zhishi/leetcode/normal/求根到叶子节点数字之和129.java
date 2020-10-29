package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by songpb on 2020/10/29.
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
 */
public class 求根到叶子节点数字之和129 {
    /**
     * 方法一：深度优先搜索
     */
//    public int sumNumbers(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode root, int prevSum) {
//        if (root == null) {
//            return 0;
//        }
//        int sum = prevSum * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            return sum;
//        } else {
//            return dfs(root.left, sum) + dfs(root.right, sum);
//        }
//    }

    /**
     * 方法二：广度优先搜索
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

}
