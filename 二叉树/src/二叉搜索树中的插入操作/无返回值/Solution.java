package 二叉搜索树中的插入操作.无返回值;

import Tree.TreeNode;

public class Solution {
    TreeNode parent; //保存遍历前一个节点

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
           return new TreeNode(val);
        }
        traversal(root, val);
        return root;
    }

    public void traversal(TreeNode cur, int val) {
        if (cur == null) {
            TreeNode node = new TreeNode(val);
            if (val > parent.val) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return;
        }

        parent = cur;
        if (cur.val > val) {
            traversal(cur.left, val);
        }
        if (cur.val < val) {
            traversal(cur.right, val);
        }
    }
}
