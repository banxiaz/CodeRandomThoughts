package 链表排序.堆排序;

import Node.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    //其实不是堆排序，相当于小顶堆
    public ListNode sortList(ListNode head) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode cur = head;
        while (cur != null) {
            queue.offer(cur);
            cur = cur.next;
        }

        int size = queue.size();
        ListNode res = queue.peek();
        for (int i = 0; i < size; ++i) {
            cur = queue.poll();
            //会在最后链表末尾加上null，避免出现环
            cur.next = queue.peek();
        }

        return res;
    }
}
