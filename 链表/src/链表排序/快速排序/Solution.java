package 链表排序.快速排序;

import Node.ListNode;

//快排在链表有序时会超时！
public class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    //[head, end)
    public ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) {
            return head;
        }

        //比中枢节点head小的放在左边，大的放在右边，但是这里是链表，只能从头结点开始遍历
        ListNode lhead = head;
        ListNode rtail = head;
        ListNode cur = head.next;
        while (cur != end) {
            ListNode next = cur.next;
            if (cur.val < head.val) {
                //头插法
                cur.next = lhead;
                lhead = cur;
            } else {
                rtail.next = cur;
                rtail = cur;
            }
            cur = next;
        }
        rtail.next = end;
        //左边排序
        ListNode newHead = quickSort(lhead, head);
        //右边排序
        head.next = quickSort(head.next, end);
        return newHead;
    }
}
