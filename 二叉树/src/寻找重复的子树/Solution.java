package 寻找重复的子树;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    //序列化
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversal(root);
        return res;
    }

    public StringBuilder traversal(TreeNode root) {
        if (root == null) {
            return new StringBuilder("#,");
        }

        StringBuilder left = traversal(root.left);
        StringBuilder right = traversal(root.right);
        StringBuilder cur = new StringBuilder().append(left).append(right).append(root.val).append(",");

        int freq = memo.getOrDefault(cur.toString(), 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(cur.toString(), freq + 1);
        return cur;
    }
}
