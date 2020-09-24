package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/24.
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class 二叉搜索树中的众数501 {
    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    /**
     * Morris 中序遍历
     */
    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    public static void main(String[] args) {
        二叉搜索树中的众数501 test = new 二叉搜索树中的众数501();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.right = new TreeNode(1);
        treeNode1.right.left = new TreeNode(3);
        System.out.println(test.findMode(treeNode1));
    }
}
