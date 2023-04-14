package 回文链表;

import Node.ListNode;

public class Solution {
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = traverse(head.next);
        //后序遍历位置，第一次比较为头节点和尾节点
        res = res && (left.val == head.val);
        left = left.next;
        return res;
    }
}
