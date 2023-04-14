package 二叉搜索树中的插入操作.有返回值;

import Tree.TreeNode;

public class Solution {
    //在找到插入点之前一层一层向下查找，在找到插入点之后一层一层回退
    //递归函数的作用：返回插入val之后的二叉树的根节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //遍历的节点为null的时候，就是要插入节点的位置了，并把插入的节点返回
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
