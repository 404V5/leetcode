package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.ListNode;

/**
 * Created by songpb on 2020/11/20.
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class 对链表进行插入排序147 {
    /**
     * 方法一：从前往后找插入点
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
