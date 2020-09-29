package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/29.
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class 二叉树的后序遍历145 {
    /**
     * 方法一：递归
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        postorder(root, res);
//        return res;
//    }
//
//    public void postorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        postorder(root.left, res);
//        postorder(root.right, res);
//        res.add(root.val);
//    }
    /**
     * 方法二：迭代
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        TreeNode prev = null;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.right == null || root.right == prev) {
//                res.add(root.val);
//                prev = root;
//                root = null;
//            } else {
//                stack.push(root);
//                root = root.right;
//            }
//        }
//        return res;
//    }
    /**
     * 方法三：Morris 遍历
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        List<Integer> tmp = new ArrayList<Integer>();
        while (node != null) {
            tmp.add(node.val);
            node = node.right;
        }
        for (int i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }
}
