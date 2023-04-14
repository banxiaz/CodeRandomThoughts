package 路径总和.找所有路径;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); //记录结果
        if (root == null) return result;

        List<Integer> path = new LinkedList<>(); //记录当前遍历的节点
        preTraversal(root, targetSum, result, path); //这里不用特殊处理
        return result;
    }

    //这是回溯的第二种写法，与【判断有没有】区分开！
    public void preTraversal(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        //path添加当前节点的路径
        //int不是引用类型！！！，不能按照引用类型来写！！！不需要回溯！！！
        path.add(root.val);
        targetSum -= root.val;

        //遇到了叶子节点
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                //path为引用，在递归过程中不断改变，不能直接放入结果集和，需要重新new一个
                res.add(new ArrayList<>(path));
            }
            return; //遇到叶子节点就返回
        }

        if (root.left != null) {
            //int不是引用类型，不需要进行回溯，这里是值传递！
            //path的改变在下一层的函数开始处
            preTraversal(root.left, targetSum, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            preTraversal(root.right, targetSum, res, path);
            path.remove(path.size() - 1);
        }
    }
}
