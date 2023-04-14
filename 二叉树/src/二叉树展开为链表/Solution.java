package 二叉树展开为链表;

import Tree.TreeNode;

public class Solution {
    //输⼊节点 root，然后以 root 为根的二叉树会被转换为链表
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 1、左右⼦树已经被拉平成⼀条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左⼦树作为右⼦树
        root.left = null;
        root.right = left;

        // 3、将原先的右⼦树接到当前右⼦树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
