package 环形链表2;

import Node.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 相遇，有环
                ListNode index1 = fast; //一个从相遇结点开始
                ListNode index2 = head; //一个从头结点开始
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1; //环入口
            }
        }
        return null;
    }
}
