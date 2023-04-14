package 最小生成树.连接所有点的最小费用;

import UnionFind.UF;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }

        edges.sort((a, b) -> a[2] - b[2]);

        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.connected(u, v)) {
                continue;
            }
            mst += edge[2];
            uf.union(u, v);
        }
        return mst;
    }
}
