package 链表排序.归并排序;

import Node.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    //排序链表[head, tail)
    public ListNode mergeSort(ListNode head, ListNode tail) {
        //终止条件
        if (head == tail) {
            return head;
        }
        if (head.next == tail) {
            head.next = null; //当只有一个节点时需要将它分离开
            return head;
        }
        //双指针遍历找中间节点
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow就是中间节点或者中间节点靠右边的节点，然后再合并两条链表
        ListNode left = mergeSort(head, slow);
        ListNode right = mergeSort(slow, tail);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy, tempLeft = left, tempRight = right;
        while (tempLeft != null && tempRight != null) {
            if (tempLeft.val <= tempRight.val) {
                temp.next = tempLeft;
                tempLeft = tempLeft.next;
            } else {
                temp.next = tempRight;
                tempRight = tempRight.next;
            }
            temp = temp.next;
        }
        if (tempLeft != null) {
            temp.next = tempLeft;
        } else if (tempRight != null) {
            temp.next = tempRight;
        }
        return dummy.next;
    }
}
