package 合并K个升序链表;

import Node.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
