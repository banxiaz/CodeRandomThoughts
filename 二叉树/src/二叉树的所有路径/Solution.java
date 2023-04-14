package 二叉树的所有路径;

import Tree.TreeNode;
import Tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        //将当前节点的值放入路径，加入节点的操作放在函数第一条
        paths.add(root.val);
        //遍历到了叶子节点，开始收集结果
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); //最后一个元素特殊处理，不加"->"
            res.add(sb.toString());
            return;
        }

        //左孩子不为空才遍历，递归与回溯一定要写在一起
        if (root.left != null) {
            //遍历左孩子，在下一层递归函数中，会首先将左孩子的值加入paths，然后收集结果，此时paths包含了左孩子的值
            traversal(root.left, paths, res);
            //回溯：因为在上面一句中，pahts是添加了左孩子的值，现在回到了这一层（上一层），需要将左孩子的值移除
            paths.remove(paths.size() - 1);
        }

        //如果右孩子不为空
        if (root.right != null) {
            //遍历右孩子，在下一层递归函数中，会首先将右孩子的值加入paths，然后收集结果，此时paths包含了右孩子的值
            traversal(root.right, paths, res);
            //回溯：因为在上面一句中，pahts是添加了右孩子的值，现在回到了这一层（上一层），需要将右孩子的值移除
            paths.remove(paths.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeTraversal.getSimpleTree();
        List<String> result = new Solution().binaryTreePaths(root);
        System.out.println(result);
    }
}
