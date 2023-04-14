package 二叉搜索树的修剪;

import Tree.TreeNode;

public class Solution {
    //递归函数：返回在[low,high]之间的二叉搜索树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //如果root（当前节点）的元素小于low的数值，那么应该递归右子树，并返回右子树符合条件的头结点
        //看看递归函数的作用！这里就相当于修剪了root节点
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        //如果root(当前节点)的元素大于high的，那么应该递归左子树，并返回左子树符合条件的头结点
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        //如果root(当前节点)的元素在[low,high]之间，分别处理它的左右孩子节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
