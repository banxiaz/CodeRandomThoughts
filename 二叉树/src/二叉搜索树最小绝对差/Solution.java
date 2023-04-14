package 二叉搜索树最小绝对差;

import Tree.TreeNode;

public class Solution {
    //中序遍历为有序序列，只要依次求相邻之间的值的最小值
    int result = Integer.MAX_VALUE;
    //记录前一个节点
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(result, cur.val - pre.val);
        }
        //刚开始 pre = null
        pre = cur;
        traversal(cur.right);
    }
}
