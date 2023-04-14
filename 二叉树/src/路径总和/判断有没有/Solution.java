package 路径总和.判断有没有;

import Tree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val); //递归开始的特殊处理
    }

    //前序遍历
    //回溯的第一种写法，注意与【找所有路径】的区别
    public boolean traversal(TreeNode cur, int count) {
        // 遇到叶子节点，并且count刚好等于0（使用减的方式），表明找到了符合条件的路径
        if (cur.left == null && cur.right == null && count == 0) {
            return true;
        }
        // 遇到叶子节点且不满足，返回false
        if (cur.left == null && cur.right == null) {
            return false;
        }

        if (cur.left != null) {
            count -= cur.left.val;
            boolean isLeft = traversal(cur.left, count);
            if (isLeft) {
                return true;
            }
            count += cur.left.val; //回溯
        }
        if (cur.right != null) {
            count -= cur.right.val;
            boolean isRight = traversal(cur.right, count);
            if (isRight) {
                return true;
            }
            count += cur.right.val; // 回溯
        }
        return false;
    }
}
