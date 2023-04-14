package 移除链表元素;

import Node.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        //虚拟头节点，指向head
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
