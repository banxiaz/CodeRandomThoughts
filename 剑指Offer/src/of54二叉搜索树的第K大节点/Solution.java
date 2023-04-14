package of54二叉搜索树的第K大节点;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int res, count;

    public int kthLargest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }

    public void traversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traversal(root.right, k); //先遍历右子树
        if (++count == k) {
            res = root.val;
            return;
        }
        traversal(root.left, k);
    }
}
