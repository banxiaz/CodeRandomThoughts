package 组合问题n取k个数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result; // 存放符合条件结果的集合
    LinkedList<Integer> path; //存放当前遍历路径

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { // 控制树的横向遍历
            path.add(i); // 处理节点
            backtracking(n, k, i + 1); // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            path.removeLast(); // 回溯，撤销处理的节点
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(10, 2));
    }
}
