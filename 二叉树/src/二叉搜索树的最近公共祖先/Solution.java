package 二叉搜索树的最近公共祖先;

import Tree.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    //递归函数：在root中查找p和q的公共祖先，找到了即不为空，直接返回，找不到，返回null
    //利用二叉搜索树的有序性，就是从上到下找第一个位于[p, q]区间的节点
    public TreeNode traversal(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return null;

        //在左子树中找
        if (cur.val > p.val && cur.val > q.val) {
            TreeNode left = traversal(cur.left, p, q);
            if (left != null) {
                return left;
            }
        }
        //在右子树中找
        else if (cur.val < p.val && cur.val < q.val) {
            TreeNode right = traversal(cur.right, p, q);
            if (right != null) {
                return right;
            }
        }
        //以上条件都不满足，那刚好就是当前节点了，直接返回就行了
        return cur;
    }

    //迭代法
    public TreeNode traversal2(TreeNode cur, TreeNode p, TreeNode q) {
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}
