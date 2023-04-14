package 反转链表递归;

import Node.ListNode;

public class Solution {
    //反转整个链表，并且返回反转后的头节点
    //递归的思路是：先反转后面的链表，再拼接前面的链表
    ListNode reverse(ListNode head) {
        if (head.next == null) {
            //这里相当于返回的是最后一个节点，而这个节点刚好是反转后的头节点
            return head;
        }
        ListNode last = reverse(head.next); //新的头节点
        head.next.next = head;
        head.next = null;
        return last;
    }

    // #################################################
    ListNode successor = null; // 后驱节点
    // 将链表从头节点开始的前 n 个节点反转（n <= 链表⻓度）
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        // 让反转之后的 head 节点和后面的节点连起来
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 将以head为头节点的链表区间[m, n]进行反转
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // 退化为从头节点开始反转
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    // #################################################

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("Null");
            return;
        }
        System.out.println(head.val);
        print(head.next);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        print(n1);
        print(new Solution().reverseBetween(n1,2,5));
    }
}
