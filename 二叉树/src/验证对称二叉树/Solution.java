package 验证对称二叉树;

import Tree.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) { //左为空，右不为空
            return false;
        } else if (left != null && right == null) { //左不为空，右为空
            return false;
        } else if (left == null && right == null) { //左右都为空
            return true;
        } else if (left.val != right.val) { //左右不为空，但值不同
            return false;
        }

        //左右节点都不为空，且数值相同的情况，那么继续判断它的内侧和外侧是否对称，此时需要用到递归
        //如果左右都对称就返回true ，有一侧不对称就返回false
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        return outSide && inSide;
    }
}
