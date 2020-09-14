package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by songpb on 2020/9/12.
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class 二叉树的层平均值637 {
    /**
     * 方法一 深度优先搜索
     */
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Integer> counts = new ArrayList<Integer>();
//        List<Double> sums = new ArrayList<Double>();
//        dfs(root, 0, counts, sums);
//        List<Double> averages = new ArrayList<Double>();
//        int size = sums.size();
//        for (int i = 0; i < size; i++) {
//            averages.add(sums.get(i) / counts.get(i));
//        }
//        return averages;
//    }
//
//    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
//        if (root == null) {
//            return;
//
//        }
//        if (level < sums.size()) {
//            sums.set(level, sums.get(level) + root.val);
//            counts.set(level, counts.get(level) + 1);
//        } else {
//            sums.add(1.0 * root.val);
//            counts.add(1);
//        }
//        dfs(root.left, level + 1, counts, sums);
//        dfs(root.right, level + 1, counts, sums);
//    }

    /**
     * 方法二 广度优先遍历
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sums = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sums += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sums / size);
        }
        return averages;
    }

    public static void main(String[] args) {
        二叉树的层平均值637 test = new 二叉树的层平均值637();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(test.averageOfLevels(root));
    }
}
