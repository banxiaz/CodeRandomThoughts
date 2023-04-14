package 二分图判定.可能的二分法;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    boolean ok = true;
    boolean[] color;
    boolean[] visited;

    //就相当于二分图的判定
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) { //从1开始
            if (!visited[i]) {
                traversal(graph, i);
            }
        }
        return ok;
    }

    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : dislikes) {
            int v = edge[0];
            int w = edge[1];
            //无向图相当于双向图
            graph[v].add(w);
            graph[w].add(v);
        }
        return graph;
    }

    public void traversal(List<Integer>[] graph, int v) {
        if (!ok) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traversal(graph, w);
            } else {
                if (color[v] == color[w]) {
                    ok = false;
                }
            }
        }
    }
}
