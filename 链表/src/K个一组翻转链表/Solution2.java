package K个一组翻转链表;

import Node.ListNode;

public class Solution2 {
    //更好理解一点
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(), prev = dummy, curr = head, next;
        dummy.next = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++) { //eg. 5/2=2 求出要反转几组
            // curr不会变，但是它前面已经不断插入了其他节点
            // 使用 头插法 在每组内部反转链表
            for (int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr; //cur是每组反转后的最后一个节点
            curr = curr.next;
        }
        return dummy.next;
    }
}
