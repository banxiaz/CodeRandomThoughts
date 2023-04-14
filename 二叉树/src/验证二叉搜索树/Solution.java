package 验证二叉搜索树;

import Tree.TreeNode;

public class Solution {
    //验证root是否是二叉搜索树  利用  二叉搜索树的中序遍历为有序序列！！！
    //陷阱1 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了
    //陷阱2 样例中最小节点 可能是int的最小值，如果这样使用最小的int来比较也是不行的

    // 用来记录前一个节点
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        //刚开始 pre=null，之后更新pre，pre保存的是上一个节点了
        pre = root;

        boolean right = isValidBST(root.right);
        return left && right;
    }
}
