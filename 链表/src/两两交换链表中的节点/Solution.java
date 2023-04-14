package 两两交换链表中的节点;

import Node.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1); // 设置一个虚拟头结点
        dummy.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dummy;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstNode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondNode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;       // 步骤一
            secondNode.next = firstNode; // 步骤二
            firstNode.next = temp;      // 步骤三
            cur = firstNode; // cur移动，准备下一轮交换
        }
        return dummy.next;
    }

}
