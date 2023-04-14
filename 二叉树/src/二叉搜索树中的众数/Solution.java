package 二叉搜索树中的众数;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result;
    TreeNode pre;
    int maxCount;
    int count;

    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);

        //如果为第一个值，或者连续节点不相等
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }

        //如果当前计数大于了最大计数，更新最大计数，同时清空result，加入当前节点
        if (count > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            result.add(root.val);
        }

        pre = root;
        traversal(root.right);
    }
}
