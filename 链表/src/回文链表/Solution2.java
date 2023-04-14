package 回文链表;

import Node.ListNode;

public class Solution2 {
    //总体思路：将链表划分为两半，将后一半反转，从头依次比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = head;
        //如果链表长度为奇数，slow指向中间节点；如果为偶数，slow指向中间右边节点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //分割两个链表

        ListNode cur1 = head;
        ListNode cur2 = reverseList(slow);
        while (cur1 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    //这里选择双指针反转链表，也可使用头插法
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
