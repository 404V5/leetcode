package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.ListNode;

/**
 * Created by songpb on 2020/10/20.
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class 重排链表143 {
    /**
     * 方法一：线性表
     */
//    public void reorderList(ListNode head) {
//        if (head == null) {
//            return;
//        }
//        List<ListNode> list = new ArrayList<ListNode>();
//        ListNode node = head;
//        while (node != null) {
//            list.add(node);
//            node = node.next;
//        }
//        int i = 0, j = list.size() - 1;
//        while (i < j) {
//            list.get(i).next = list.get(j);
//            i++;
//            if (i == j) {
//                break;
//            }
//            list.get(j).next = list.get(i);
//            j--;
//        }
//        list.get(i).next = null;
//    }
    /**
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
