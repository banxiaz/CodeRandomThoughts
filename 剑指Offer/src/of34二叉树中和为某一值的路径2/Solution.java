package of34二叉树中和为某一值的路径2;


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
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        if (root == null) {
            return res;
        }

        traversal(root, target, 0);
        return res;
    }

    public void traversal(TreeNode root, int target, int count) {
        path.add(root.val);
        count += root.val;

        if (root.left == null && root.right == null) {
            if (count == target) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        if (root.left != null) {
            traversal(root.left, target, count);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, target, count);
            path.remove(path.size() - 1);
        }
    }
}
