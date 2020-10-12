package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.ListNode;

/**
 * Created by songpb on 2020/10/13.
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class 两两交换链表中的节点24 {
    /**
     * 方法一：递归
     */
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = head.next;
//        head.next = swapPairs(newHead.next);
//        newHead.next = head;
//        return newHead;
//    }
    /**
     * 方法二：迭代
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

}
