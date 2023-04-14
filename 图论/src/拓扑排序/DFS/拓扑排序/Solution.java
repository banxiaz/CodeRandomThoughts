package 拓扑排序.DFS.拓扑排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<Integer> postOrder = new ArrayList<>();
    boolean hasCycle = false;
    boolean[] visited, path;

    //联想二叉树：【后序遍历的逆序】就是拓扑排序的结果
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traversal(graph, i);
        }

        if (hasCycle) {
            return new int[]{};
        }

        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
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
        if (path[s]) {
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        path[s] = true;
        //遍历同一个节点的出度
        //在for循环里面和外面的唯一区别就是对根节点的处理
        for (int t : graph[s]) {
            traversal(graph, t);
        }
        //后序遍历位置
        postOrder.add(s);
        path[s] = false;
    }
}
