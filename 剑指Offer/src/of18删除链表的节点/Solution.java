package of18删除链表的节点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    //时间复杂的O(n)
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
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

    //时间复杂的O(1)写法，与原有题目不同，需要给出待删除节点
    public ListNode deleteNode2(ListNode head, ListNode val) {
        if (head == null) {
            return null;
        }
        //只有一个节点且就是要删除的节点
        if (head == val && head.next == null) {
            return null;
        }

        //如果是最后一个节点，也需要遍历找到它的前驱节点
        if (val.next == null) {
            ListNode cur = head;
            while (cur.next.next != val) {
                cur = cur.next;
            }
            cur.next = null;
        } else {
            //将后一个节点的值覆盖当前节点，然后当前节点指向后置节点的后置
            val.val = val.next.val;
            val.next = val.next.next;
        }
        return head;
    }
}
