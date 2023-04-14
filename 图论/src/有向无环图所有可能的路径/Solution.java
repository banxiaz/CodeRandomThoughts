package 有向无环图所有可能的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph[0].length == 0) {
            return null;
        }

        res = new ArrayList<>();
        path = new ArrayList<>();

        path.add(0);
        traversal(graph, 0);
        path.remove(path.size()-1);

        System.out.println(path); //就是这里了，已解决这个问题
        return res;
    }

    //会存在一个问题：有一个节点还存在于path中
    public void traversal(int[][] graph, int s) {
        if (s == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[s]) {
            path.add(v);
            traversal(graph, v);
            //回溯，撤销上一步的操作
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }
}
