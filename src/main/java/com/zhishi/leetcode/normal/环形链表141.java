package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by songpb on 2020/10/9.
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class 环形链表141 {
    /**
     * 方法一：哈希表
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    /**
     * 方法二：快慢指针
     */
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }
}
