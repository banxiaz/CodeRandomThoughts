package 翻转二叉树;

import Tree.TreeNode;
import Tree.TreeTraversal;

public class Solution {
    //使用前序、后序和层次遍历都可以，唯独中序不行
    //在遍历二叉树的过程中，交换每一个遍历到的节点的左右节点就可以翻转整颗树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeTraversal.getSimpleTree();
        TreeTraversal.preOrderTraversal(root);

        root = new Solution().invertTree(root);
        TreeTraversal.preOrderTraversal(root);

    }
}
