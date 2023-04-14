package 二叉搜索树转换为有序链表;

import Tree.TreeNode;

public class Solution {
    TreeNode pre, head;

    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return head;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
            root.left = null;
        }
        pre = root;
        traverse(root.right);
    }
}
