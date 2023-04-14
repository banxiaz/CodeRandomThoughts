package 构造二叉树中序和后序;

import Tree.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    //返回以当前 前序inorder与后序postorder 构成的树
    //中序区间：[inorderBegin, inorderEnd)，后序区间[postorderBegin, postorderEnd)
    public TreeNode traversal(int[] inorder, int inorderBegin, int inorderEnd, int[] postorder, int postorderBegin, int postorderEnd) {
        //1.如果后序为空，说明到了空节点
        if (postorderBegin == postorderEnd) {
            return null;
        }
        //2.后序遍历数组的最后一个元素，就是当前的中间节点
        int rootValue = postorder[postorderEnd - 1];
        //后序数组的最后一个元素为当前节点
        TreeNode root = new TreeNode(rootValue);
        //如果当前节点为叶子节点了，直接返回，不用构造左右子树了
        if (postorderEnd - postorderBegin == 1) {
            return root;
        }

        //3.在中序中找切割点
        int delimiterIndex;
        for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) {
                break;
            }
        }
        //4.切割中序数组。得到 中序左数组和中序右数组
        // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;

        //5.切割后序数组。得到 后序左数组和后序右数组
        // 左后序区间，左闭右开[leftPostorderBegin, leftPostorderEnd)
        int leftPostorderBegin = postorderBegin;
        int leftPostorderEnd = postorderBegin + (delimiterIndex - inorderBegin);
        // 右后序区间，左闭右开[rightPostorderBegin, rightPostorderEnd)
        int rightPostorderBegin = postorderBegin + (delimiterIndex - inorderBegin);
        int rightPostorderEnd = postorderEnd - 1;

        //6.递归构造左子树和右子树
        root.left = traversal(inorder, leftInorderBegin, leftInorderEnd, postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = traversal(inorder, rightInorderBegin, rightInorderEnd, postorder, rightPostorderBegin, rightPostorderEnd);
        return root;
    }
}
