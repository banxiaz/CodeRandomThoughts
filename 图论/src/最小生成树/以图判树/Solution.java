package 最小生成树.以图判树;

import UnionFind.UF;

public class Solution {
    boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        // 遍历所有边，将组成边的两个节点进⾏连接
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // 若两个节点已经在同⼀连通分量中，会产⽣环
            if (uf.connected(u, v)) {
                return false;
            }
            uf.union(u, v);
        }
        // 要保证最后只形成了⼀棵树，即只有⼀个连通分量
        return uf.count() == 1;
    }
}
