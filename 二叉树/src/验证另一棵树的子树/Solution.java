package 验证另一棵树的子树;

import Tree.TreeNode;

public class Solution {
    // 一个树是另一个树的子树 则:
    // - 要么这两个树相等
    // - 要么这个树是左树的子树
    // - 要么这个树是右树的子树

    // 判断subroot是否是roo的子树
    // root 树上的节点数量范围是 [1, 2000]
    // subRoot 树上的节点数量范围是 [1, 1000]
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //subRoot不可能为null，但是root在递归的过程中可能为null
        if (root == null) return false;

        return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //判断left和right是否相等
    public boolean isSametree(TreeNode left, TreeNode right) {
        if (left != null && right == null) return false;
        else if (left == null && right != null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean leftSide = isSametree(left.left, right.left);
        boolean rightSide = isSametree(left.right, right.right);
        return leftSide && rightSide;
    }
}
