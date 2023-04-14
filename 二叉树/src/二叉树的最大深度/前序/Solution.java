package 二叉树的最大深度.前序;

import Tree.TreeNode;
import Tree.TreeTraversal;

public class Solution {
    int result; //result保持最大深度

    public void getDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) { //当前节点为叶子，递归终止，回溯
            result = Math.max(depth, result); //收集一次结果
            return;
        }

        if (node.left != null) { //不为空才能进入递归，即不处理空节点
            depth++;  // 深度+1
            getDepth(node.left, depth); //还有一种写法为 getDepth(node.left, depth+1)是隐藏回溯
            depth--;  // 回溯，深度-1
        }
        if (node.right != null) { //不为空才能进入递归
            depth++;  // 深度+1
            getDepth(node.right, depth);
            depth--;  // 回溯，深度-1
        }
    }

    public int maxDepth(TreeNode root) {
        result = 0;
        if (root == null) {
            return result;
        }
        getDepth(root, 1); //根节点深度为1
        return result;
    }

    public static void main(String[] args) {
        // TreeNode root = TreeTraversal.getSimpleTree();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(17);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        int depth = new Solution().maxDepth(root);
        System.out.println(depth);
    }
}
