package 二分图判定.判断二分图.DFS;

public class Solution {
    // 记录图是否符合⼆分图性质
    boolean ok = true;
    // 记录图中节点的颜⾊，false 和 true 代表两种不同颜⾊，遍历完之后这个里面就记录了一种可能的分法
    boolean[] color;
    // 记录图中节点是否被访问过
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        // 因为图不⼀定是连通的，可能存在多个子图
        // 所以要把每个节点都作为起点进行⼀次遍历
        // 如果发现任何⼀个⼦图不是⼆分图，整幅图都不算⼆分图
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traversal(graph, i);
            }
        }
        return ok;
    }

    public void traversal(int[][] graph, int v) {
        // 如果已经确定不是⼆分图了，就不⽤浪费时间再递归遍历了
        if (!ok) {
            return;
        }

        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜⾊
                color[w] = !color[v];
                // 继续遍历 w
                traversal(graph, w);
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜⾊判断是否是⼆分图
                if (color[w] == color[v]) {
                    // 若相同，则此图不是⼆分图
                    ok = false;
                }
            }
        }
    }
}
