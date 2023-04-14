package 完全二叉树的节点个数.完全二叉树;

import Tree.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 0, rightHeight = 0;

        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }

        //如果是满二叉树
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }
        //如果不是满二叉树，递归调用，分别求得左右子树的节点数，再加上当前的节点(1)
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
