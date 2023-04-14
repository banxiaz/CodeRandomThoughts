package 反转链表;

import Node.ListNode;

public class Solution {
    // 整个链表反转可以使用双指针
    // 部分链表反转可以使用头插法

    //双指针
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList2(head.next); //此时head.nest 还没有切断，last为返回的头节点
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 虚拟头节点，迭代
    public ListNode reverseList3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }

}
