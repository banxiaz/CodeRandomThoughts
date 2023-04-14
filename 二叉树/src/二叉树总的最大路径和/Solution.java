package 二叉树总的最大路径和;

import Tree.TreeNode;

public class Solution {
    int res = Integer.MIN_VALUE;

    /**
     对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    //返回以root为根的二叉树中的最大路径和
    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左右如果为负，那么就不用包含左右孩子了
        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));

        res = Math.max(res, left + right + root.val);
        //如果当前root想被其他路径包含，那么当前的路径只能选择左右孩子中较大的那一条，而不能将左右孩子都包含。
        return Math.max(left, right) + root.val;
    }
}
