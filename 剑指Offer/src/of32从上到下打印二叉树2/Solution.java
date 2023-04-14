package of32从上到下打印二叉树2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //或者使用正常的遍历顺序，而使用双端队列收集结果
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int level = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = stack1.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if (level % 2 != 0) {
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }
            level++;
            res.add(temp);
            Stack<TreeNode> stack3 = stack1;
            stack1 = stack2;
            stack2 = stack3;
        }
        return res;
    }
}
