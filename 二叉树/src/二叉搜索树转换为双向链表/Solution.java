package 二叉搜索树转换为双向链表;

import Tree.TreeNode;

public class Solution {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历到的第一个节点，作为头节点，用head节点记录
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        traverse(root.right);
    }
}
