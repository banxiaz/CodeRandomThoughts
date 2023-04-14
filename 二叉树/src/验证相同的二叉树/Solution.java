package 验证相同的二叉树;

import Tree.TreeNode;

public class Solution {
    //这个方法返回以p q为根节点的二叉树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) { //左为空，右不为空
            return false;
        } else if (p != null && q == null) { //左不为空，右为空
            return false;
        } else if (p == null && q == null) { //左右都为空
            return true;
        } else if (p.val != q.val) { //左右不为空，但值不同
            return false;
        }

        //左右节点都不为空，且数值相同的情况，那么继续判断它的左侧和右侧是否相等，此时需要用到递归
        //如果左右都对称就返回true ，有一侧不对称就返回false
        boolean outSide = isSameTree(p.left, q.left);
        boolean inSide = isSameTree(p.right, q.right);
        return outSide && inSide;
    }
}
