package 链表相交;

import Node.ListNode;

public class Solution2 {
    //很巧妙的一种方法：就相当于分别将两条链表拼接在另一条链表后面，如果链表有相交，在遍历的过程中一定会相等
    //最坏的情况下要遍历完两条链表长度，但是也是常数级别
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
