package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.TreeNode;

/**
 * Created by songpb on 2020/9/27.
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class 二叉搜索树的最近公共祖先235 {
    /**
     * 方法一：两次遍历
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> path_p = getPath(root, p);
//        List<TreeNode> path_q = getPath(root, q);
//        TreeNode ancestor = null;
//        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
//            if (path_p.get(i) == path_q.get(i)) {
//                ancestor = path_p.get(i);
//            } else {
//                break;
//            }
//        }
//        return ancestor;
//    }
//
//    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
//        List<TreeNode> path = new ArrayList<TreeNode>();
//        TreeNode node = root;
//        while (node != target) {
//            path.add(node);
//            if (target.val < node.val) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        path.add(node);
//        return path;
//    }

    /**
     * 方法二：一次遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
