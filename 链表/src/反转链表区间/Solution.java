package 反转链表区间;

import Node.ListNode;

public class Solution {
    //AC!
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //添加虚拟头节点，相当于翻转[left+1, right+1]
        ListNode dummy = new ListNode();
        dummy.next = head;

        //找到第一个翻转节点的前驱节点pre
        ListNode leftBegin = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftBegin = leftBegin.next;
        }

        //开始翻转
        ListNode pre = null, cur = leftBegin.next, nextNode;
        int round = right - left + 1;
        while (round != 0) {
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
            round--;
        }

        //将翻转后的部分链表再连接起来
        leftBegin.next.next = cur;
        leftBegin.next = pre;

        return dummy.next;
    }
}
