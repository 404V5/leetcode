package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/14.
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class 二叉树的中序遍历94 {
    /**
     * 方法一 递归
     *
     * @param root
     * @return List<Integer>
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        inorder(root, res);
//        return res;
//    }
//
//    public void inorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, res);
//        res.add(root.val);
//        inorder(root.right, res);
//    }

    /**
     * 方法二 栈
     *
     * @param root
     * @return List<Integer>
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        while (root != null || !stk.isEmpty()) {
//            while (root != null) {
//                stk.push(root);
//                root = root.left;
//            }
//            root = stk.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
//    }

    /**
     * 方法三 Morris 中序遍历
     *
     * @param root
     * @return List<Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        二叉树的中序遍历94 test = new 二叉树的中序遍历94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(test.inorderTraversal(root));
    }
}
