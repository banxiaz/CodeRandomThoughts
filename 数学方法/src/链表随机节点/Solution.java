package 链表随机节点;

import Node.ListNode;

import java.util.Random;

//水塘抽样问题
public class Solution {
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random r = new Random();
        int count = 0, res = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            // ⽣成⼀个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == r.nextInt(count)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }

    /* 返回链表中 k 个随机节点的值 */
    int[] getRandomK(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;
        // 前 k 个元素先默认选上
        for (int j = 0; j < k && p != null; j++) {
            res[j] = p.val;
            p = p.next;
        }
        int i = k;
        // while 循环遍历链表
        while (p != null) {
            // ⽣成⼀个 [0, i) 之间的整数
            int j = r.nextInt(++i);
            // 这个整数⼩于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
