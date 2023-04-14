package 构造二叉树中序和前序;

import Tree.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    //[左，右)
    public TreeNode traversal(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd) {
        if (preorderBegin == preorderEnd) {
            return null;
        }

        //叶子节点：前序中只有一个元素
        int rootValue = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootValue);
        if (preorderEnd - preorderBegin == 1) {
            return root;
        }

        //在中序中找切割点
        int delimiterIndex;
        for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) break;
        }
        //切割中序数组，得到中序左数组和中序右数组
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;

        //切割前序数组。得到 前序左数组和前序右数组
        int leftPreorderBegin = preorderBegin + 1;
        int leftPreorderEnd = preorderBegin + 1 + delimiterIndex - inorderBegin;
        int rightPreorderBegin = preorderBegin + 1 + delimiterIndex - inorderBegin;
        int rightPreorderEnd = preorderEnd;

        //构造左右子树
        root.left = traversal(preorder, leftPreorderBegin, leftPreorderEnd, inorder, leftInorderBegin, leftInorderEnd);
        root.right = traversal(preorder, rightPreorderBegin, rightPreorderEnd, inorder, rightInorderBegin, rightInorderEnd);

        return root;
    }
}
