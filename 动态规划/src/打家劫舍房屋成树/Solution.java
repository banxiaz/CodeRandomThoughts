package 打家劫舍房屋成树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    // 树形dp入门，状态标记递归
    // 【下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱】
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷 + 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;

    public int rob(TreeNode root) {
        int[] res = traversal(root);
        return Math.max(res[0], res[1]);
    }

    public int[] traversal(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res; //相当于dp数组初始化
        }

        int[] left = traversal(root.left);
        int[] right = traversal(root.right);

        //不偷当前节点：可以考虑左右孩子节点，但是不知道左右孩子是偷好还是不偷好，所以取两个的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点：左孩子不能偷，右孩子不能偷，当前节点偷
        res[1] = root.val + left[0] + right[0];
        return res;
    }


    //暴力递归，超出时间限制，优化：记忆化搜索 map
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 偷父节点
        int val1 = root.val;
        if (root.left != null) {
            // 跳过root->left，相当于不考虑左孩子了
            val1 += rob1(root.left.left) + rob1(root.left.right);
        }
        if (root.right != null) {
            // 跳过root->right，相当于不考虑右孩子了
            val1 += rob1(root.right.left) + rob1(root.right.right);
        }

        // 不偷父节点
        int val2 = rob1(root.left) + rob1(root.right);
        //两者的最大值
        return Math.max(val1, val2);
    }

}
