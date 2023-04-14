package 删除链表的倒数第N个结点;

import Node.ListNode;

public class Solution {
    //1.双指针，虚拟头节点
    //2.fast先走n+1步，slow再和fast一起走，此时，fast指向null时，slow刚好指向待删除节点的前驱节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        //移动了n+1次
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
