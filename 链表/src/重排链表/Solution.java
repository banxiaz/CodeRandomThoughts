package 重排链表;

import Node.ListNode;

public class Solution {
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

    // 中间节点为中间或者左边一个
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 双指针法翻转链表
    private ListNode reverseList(ListNode l2) {
        ListNode pre = null;
        ListNode cur = l2;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //l1在前，l2在后
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Next, l2Next;
        while (l1 != null && l2 != null) {
            l1Next = l1.next;
            l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
