package 二叉树的直径;

import Tree.TreeNode;

public class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return maxDiameter;
    }

    //相当于求最大高度
    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }
}
