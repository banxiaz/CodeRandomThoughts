package 最小生成树.Prim;

import java.util.List;
import java.util.PriorityQueue;

/*
 * 复杂度分析：节点个数V，边的条数E
 * 时间复杂度：总体O(ElogE)
 * */
public class Prim {
    // 核⼼数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq;
    // 类似 visited 数组的作⽤，记录哪些节点已经成为最⼩⽣成树的⼀部分
    private boolean[] inMST;
    // 记录最⼩⽣成树的权重和
    private int weightSum = 0;
    // graph 是⽤邻接表表示的⼀幅图，
    // graph[s] 记录节点 s 所有相邻的边，
    // 三元组 int[]{from, to, weight} 表示⼀条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>((a, b) -> {
            // 按照边的权重从⼩到⼤排序
            return a[2] - b[2];
        });
        // 图中有 n 个节点
        int n = graph.length;
        this.inMST = new boolean[n];

        // 随便从⼀个点开始切分都可以，我们不妨从节点 0 开始
        inMST[0] = true;
        cut(0);
        // 不断进⾏切分，向最⼩⽣成树中添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                // 节点 to 已经在最⼩⽣成树中，跳过
                // 否则这条边会产⽣环
                continue;
            }
            // 将边 edge 加⼊最⼩⽣成树
            weightSum += weight;
            inMST[to] = true;
            // 节点 to 加⼊后，进⾏新⼀轮切分，会产⽣更多横切边
            cut(to);
        }
    }

    // 将 s 的横切边加⼊优先队列
    private void cut(int s) {
        // 遍历 s 的邻边
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inMST[to]) {
                // 相邻接点 to 已经在最⼩⽣成树中，跳过
                // 否则这条边会产⽣环
                continue;
            }
            // 加⼊横切边队列
            pq.offer(edge);
        }
    }

    // 最⼩⽣成树的权重和
    public int weightSum() {
        return weightSum;
    }

    // 判断最⼩⽣成树是否包含图中的所有节点
    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}

