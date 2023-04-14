package of06从尾到头打印链表;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int[] res = new int[len];
        int index = len - 1;
        cur = head;
        while (cur != null) {
            res[index--] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    //递归：先打印后面节点，再打印当前节点
    public void reversePrint2(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(Arrays.toString(new Solution().reversePrint(head)));
    }
}
