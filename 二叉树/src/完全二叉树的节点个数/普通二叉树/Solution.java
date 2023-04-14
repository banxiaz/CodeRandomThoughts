package 完全二叉树的节点个数.普通二叉树;

import Tree.TreeNode;

public class Solution {
    //计算以root的节点数量，递归调用
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int treeNum = 1 + leftNum + rightNum;
        return treeNum;
    }
}
