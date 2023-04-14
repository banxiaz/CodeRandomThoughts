package 树最后一行左下角的值.递归;

import Tree.TreeNode;

public class Solution {
    int maxLen = -1; //假设深度没有负值
    int maxLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 1); //根节点深度为1
        return maxLeftValue;
    }

    //前序遍历保证：如果是找到了最后一行，那么第一个遍历的一定是最左的值，记录下来就是结果
    //前序加回溯
    public void traversal(TreeNode root, int leftLen) {
        //如果遍历到叶子节点，可以尝试更新最大深度和左下角的值
        if (root.left == null && root.right == null) {
            if (leftLen > maxLen) {
                maxLen = leftLen;
                maxLeftValue = root.val;
            }
            return;
        }
        if (root.left != null) {
            leftLen++;
            traversal(root.left, leftLen);
            leftLen--; //回溯
        }
        if (root.right != null) {
            leftLen++;
            traversal(root.right, leftLen);
            leftLen--; //回溯
        }
    }
}
