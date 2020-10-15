package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by songpb on 2020/10/15.
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class 填充每个节点的下一个右侧节点指针116 {
    /**
     * 方法一：层次遍历
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }
    /**
     * 方法二：使用已建立的 \text{next}next 指针
     */
//    public Node connect(Node root) {
//        if (root == null) {
//            return root;
//        }
//        // 从根节点开始
//        Node leftmost = root;
//        while (leftmost.left != null) {
//            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
//            Node head = leftmost;
//            while (head != null) {
//                // CONNECTION 1
//                head.left.next = head.right;
//                // CONNECTION 2
//                if (head.next != null) {
//                    head.right.next = head.next.left;
//                }
//                // 指针向后移动
//                head = head.next;
//            }
//
//            // 去下一层的最左的节点
//            leftmost = leftmost.left;
//        }
//        return root;
//    }

    /**
     * 方法三:完全二叉树
     */
//    public Node connect(Node root) {
//        if(root==null) return null;
//        Node head=root;
//        LinkedList <Node> list = new LinkedList<>();
//        list.add(root);
//        while(!list.isEmpty()){
//            int length = list.size();
//            for(int i=0;i<length;++i){
//                Node temp = list.pop();
//                if(temp.left != null){
//                    list.add(temp.left);
//                    list.add(temp.right);
//                }
//                if(i!=length-1) temp.next=list.peek();
//                else temp.next=null;
//            }
//        }
//        return head;
//    }
}
