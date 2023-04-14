package 合并二叉树;

import Tree.TreeNode;

public class Solution {
    //构造或者比较二叉树其实非常简单
    //一定要搞清楚这个递归函数是干什么的，理清楚单层递归的逻辑，那么递归调用一定不会错的，相信！！！
    //比如：这个方法返回以root1和root2为根节点的合并的二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
