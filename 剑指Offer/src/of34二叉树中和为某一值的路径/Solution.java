package of34二叉树中和为某一值的路径;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if (root == null) {
            return res;
        }

        path.add(root.val);
        traversal(root, res, path, target, root.val);
        return res;
    }

    //遍历到叶子节点且count==target即可收集结果
    public void traversal(TreeNode root, List<List<Integer>> res, List<Integer> path, int target, int count) {
        if (root.left == null && root.right == null) {
            if (count == target) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            traversal(root.left, res, path, target, count + root.left.val); //count隐藏回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, res, path, target, count + root.right.val); //count隐藏回溯
            path.remove(path.size() - 1);
        }
    }
}
