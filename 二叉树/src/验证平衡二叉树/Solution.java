package 验证平衡二叉树;

import Tree.TreeNode;

public class Solution {
    //判断root是否是平衡二叉树？是：返回树的最大高度，不是：返回-1
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //获取左子树的高度
        int leftHeight = getHeight(root.left);
        //如果左子树已经不满足平衡二叉树(-1)了，直接返回-1，表示不满足，不用搜索整棵树
        if (leftHeight == -1) {
            return -1;
        }
        //获取右子树的高度
        int rightHeight = getHeight(root.right);
        //如果右子树已经不满足平衡二叉树了，直接返回-1，表示不满足
        if (rightHeight == -1) {
            return -1;
        }
        //如果左右子树的高度差大于1，那么也不满足平衡二叉树了，返回-1表示不满足
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //还满足平衡二叉树，返回左右子树中的高度最大者+1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
