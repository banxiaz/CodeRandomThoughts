package 用数组构建二叉树;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public TreeNode construct_binary_tree(int[] vec) {
        TreeNode[] vecTree = new TreeNode[vec.length];

        for (int i = 0; i < vec.length; i++) {
            if (vec[i] != -1) {
                vecTree[i] = new TreeNode(vec[i]);
            } else {
                vecTree[i] = null;
            }
        }

        for (int i = 0; i * 2 + 2 < vec.length; i++) {
            if (vecTree[i] != null) {
                vecTree[i].left = vecTree[i * 2 + 1];
                vecTree[i].right = vecTree[i * 2 + 2];
            }
        }
        return vecTree[0];
    }

    public List<List<Integer>> print_binary_tree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                //空节点可以入队列
                TreeNode temp = queue.poll();
                if (temp != null) {
                    itemList.add(temp.val);
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                } else {
                    itemList.add(-1);
                }
            }
            result.add(itemList);
        }
        return result;
    }

    public static void main(String[] args) {
        // 注意本代码没有考虑输入异常数据的情况
        // 用 -1 来表示null
        int[] vec = {4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8};
        TreeNode root = new Solution().construct_binary_tree(vec);
        List<List<Integer>> result = new Solution().print_binary_tree(root);
        System.out.println(result);
    }
}
