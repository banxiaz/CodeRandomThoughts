package 左叶子之和;

import Tree.TreeNode;

public class Solution {
    //后序遍历，需要通过递归函数的返回值来累加求取左叶子数值之和
    //以root为根节点的所有左叶子之和 = root的左子树 + root.left的左子树 + root.right的左子树
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        //左叶子节点的判断条件：当前节点的左孩子不为空，左孩子的左右孩子为空，那么，当前节点的左孩子为一个左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue += root.left.val;
        }

        int sum = midValue + leftValue + rightValue;
        return sum;
    }
    //平时我们解二叉树的题目时，已经习惯了通过节点的左右孩子判断本节点的属性，而本题我们要通过节点的父节点判断本节点的属性。
}
