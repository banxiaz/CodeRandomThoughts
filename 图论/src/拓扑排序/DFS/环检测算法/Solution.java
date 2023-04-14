package 拓扑排序.DFS.环检测算法;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean[] visited;
    boolean[] path;
    boolean hasCycle = false;

    //什么时候无法修完所有课程？当存在循环依赖的时候
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traversal(graph, i);
        }

        return !hasCycle;
    }

    //转换为邻接表
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    public void traversal(List<Integer>[] graph, int s) {
        //又遇到当前遍历过的节点，那就是有环
        if (path[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        //前序位置
        path[s] = true;
        for (int t : graph[s]) {
            traversal(graph, t);
        }
        //后序位置
        path[s] = false;
    }
}
