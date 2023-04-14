package 二叉搜索子树的最大键值和;

import Tree.TreeNode;

public class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    // res[0] 记录以 root 为根的⼆叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
    // res[1] 记录以 root 为根的⼆叉树所有节点中的最小值；
    // res[2] 记录以 root 为根的⼆叉树所有节点中的最大值；
    // res[3] 记录以 root 为根的⼆叉树所有节点值之和。。。。
    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        // 判断以 root 为根的⼆叉树是不是 BST
        int[] res = new int[4];

        //如果是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val); //这里主要是为了处理叶子节点
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
