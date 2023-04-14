package 二叉树的最小深度.后序;

import Tree.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);  //左
        int rightDepth = minDepth(root.right);//右

        // 左子树为空，右子树不为空，这时并不是最低点，最小深度是 1 + 右子树的深度
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        // 右子树为空，左子树不为空，这时并不是最低点，最小深度是 1 + 左子树的深度
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        //如果左右子树都不为空，返回左右子树深度最小值 + 1
        int depth = 1 + Math.min(leftDepth, rightDepth);
        return depth;
    }
}
