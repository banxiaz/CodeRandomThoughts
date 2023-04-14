package 构造最大二叉树;

import Tree.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    //在左闭右开区间[left, right)，构造二叉树，返回最大值构成的根节点
    public TreeNode traversal(int[] nums, int left, int right) {
        //遇到了空节点，返回
        if (left == right) {
            return null;
        }
        // 其实不用判断是否有叶子节点，因为如果有叶子结点的话，数组长度>=1，还是可以划分的
        // 分割点下标：maxValueIndex
        int maxValueIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = traversal(nums, left, maxValueIndex);
        root.right = traversal(nums, maxValueIndex + 1, right);
        return root;
    }
}
