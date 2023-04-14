package 二叉搜索树中的搜索;

import Tree.TreeNode;

public class Solution {
    //实现了在以root为根节点的树中找val
    public TreeNode searchBST(TreeNode root, int val) {
        //如果root为空，或者找到这个数值了，就返回root节点
        if (root == null || root.val == val) {
            return root;
        }
        //如果当前节点的值大于要找的值，只能去左子树去找
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }

    //迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
