package com.zhishi.leetcode.normal;

import com.zhishi.leetcode.util.ListNode;

/**
 * Created by songpb on 2020/10/10.
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class 环形链表贰142 {
    /**
     * 方法一：哈希表
     */
//    public ListNode detectCycle(ListNode head) {
//        ListNode pos = head;
//        Set<ListNode> visited = new HashSet<ListNode>();
//        while (pos != null) {
//            if (visited.contains(pos)) {
//                return pos;
//            } else {
//                visited.add(pos);
//            }
//            pos = pos.next;
//        }
//        return null;
//    }

    /**
     * 方法二：快慢指针
     */

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}