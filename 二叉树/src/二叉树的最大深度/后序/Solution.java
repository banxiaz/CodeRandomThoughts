package 二叉树的最大深度.后序;

import Tree.TreeNode;

public class Solution {
    //后序相当于求高度，但是根节点的高度的值就等于二叉树的最大深度！！！
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left); //左
        int rightDepth = maxDepth(root.right); //中
        int depth = 1 + Math.max(leftDepth, rightDepth); //取左右子树中的最大值加1，作为当前节点的最大深度
        return depth;
    }
}
