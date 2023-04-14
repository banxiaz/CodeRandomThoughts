package 最小生成树.Kruskal;

import UnionFind.UF;

import java.util.Arrays;

/*
* 复杂度分析：节点个数V，边的条数E
* 空间复杂度：装满所有边O(E)，UF算法O(V)，总体O(V+E)
* 时间复杂度：排序O(ElogE)，UF算法O(E)，总体O(ElogE)
* */

public class Solution {
    //计算最小生成树的权重和
    public int miniumCost(int n, int[][] connections) {
        //编号为1,2,3...
        UF uf = new UF(n + 1);
        //对所有的边按照权重从小到大排序
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        //记录最小生成树的权重之和
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            //如果已经连通，这条边加入会产生环，则不能加入mst
            if (uf.connected(u, v)) {
                continue;
            }
            //否则可以加入最小生成树
            mst += edge[3];
            //将加入的节点连通
            uf.union(u, v);
        }

        //保证所有节点都连通
        //但是节点0没有使用，0会占据一个连通分量，所以这里至少有2个连通分量
        return uf.count() == 2 ? mst : -1;
    }
}
