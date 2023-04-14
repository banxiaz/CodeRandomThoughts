package 合并K个升序链表;

import Node.ListNode;

public class Solution {
    //经典分治法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftPart = merge(lists, left, mid);
        ListNode rightPart = merge(lists, mid + 1, right);
        return mergeTwoLists(leftPart, rightPart);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) {
            cur.next = b;
        } else {
            cur.next = a;
        }
        return dummy.next;
    }

    //合并两条链表的递归写法，不推荐
    public ListNode mergeTwoLists222(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists222(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists222(l1, l2.next);
            return l2;
        }
    }
}
