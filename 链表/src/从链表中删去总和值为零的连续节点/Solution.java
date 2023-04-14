package 从链表中删去总和值为零的连续节点;

import Node.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode removeZeroSumSubLists(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        // 首次遍历建立 <前缀和，当前节点> 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        ListNode cur = dummy;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        // 第二遍遍历，若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0，直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
