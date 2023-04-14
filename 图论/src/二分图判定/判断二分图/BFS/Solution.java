package 二分图判定.判断二分图.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean ok = true;
    boolean[] color;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }
        return ok;
    }

    public void bfs(int[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    color[next] = !color[cur];
                    visited[next] = true;
                    queue.offer(next);
                } else {
                    if (color[cur] == color[next]) {
                        ok = false;
                    }
                }
            }
        }
    }
}
