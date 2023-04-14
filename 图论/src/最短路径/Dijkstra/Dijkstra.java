package 最短路径.Dijkstra;

import java.util.*;

class State {
    // 图节点的 id
    int id;
    // 从 start 节点到当前节点的距离
    int distFromStart;

    State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

//代码不能直接运行！！！
public class Dijkstra {
    List<int[]>[] graph;

    // 输⼊⼀幅图和⼀个起点 start，计算 start 到其他节点的最短距离
    // 标准的 Dijkstra 算法会把从起点 start 到所有其他节点的最短路径都算出来
    int[] dijkstra(int start, List<int[]>[] graph) {
        this.graph = graph;

        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最⼩值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) ->
                a.distFromStart - b.distFromStart
        );

        // 从起点 start 开始进⾏ BFS
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            // if (curNodeID == target) {
            //     return 到target的最短路径，算是一个优化！
            // }

            if (curDistFromStart > distTo[curNodeID]) {
                // 对于同⼀个节点，我们可能会遍历多次，⽽且每次的 distFromStart可能都不⼀样
                // 所以队列会重复包含同样的编号节点，但是他们的curDistFromStart是不同的，而 distTo[curNodeID] 却全局更新了
                // 这里表明已经有⼀条更短的路径到达 curNode 节点了
                continue;
            }

            // 将 curNode 的相邻节点装⼊队列
            for (int[] nextNodeID : adj(curNodeID)) {
                // 看看从 curNode 达到 nextNode 的距离是否会比直接到 nextNode 更短
                int distToNextNode = distTo[curNodeID] + weight(curNodeID, nextNodeID[0]);
                if (distTo[nextNodeID[0]] > distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID[0]] = distToNextNode;
                    // 将这个节点以及距离放⼊队列
                    pq.offer(new State(nextNodeID[0], distToNextNode));
                }
            }
        }
        return distTo;
    }


    // 返回节点 from 到节点 to 之间的边的权重
    int weight(int from, int to) {
        for (int[] n : adj(from)) {
            if (n[0] == to) {
                return n[1];
            }
        }
        // 其实不可能到到这里
        return Integer.MAX_VALUE;
    }

    // 输⼊节点 s 返回 s 的相邻节点
    List<int[]> adj(int s) {
        return graph[s];
    }

    public static void main(String[] args) {
        List<int[]>[] graph = new List[6];
        for (int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }
        //构造图
        graph[0].add(new int[]{4, 5});
        graph[0].add(new int[]{3, 8});
        graph[0].add(new int[]{1, 9});

        graph[1].add(new int[]{2, 2});

        graph[2].add(new int[]{5, 1});

        graph[3].add(new int[]{5, 2});

        graph[4].add(new int[]{5, 6});

        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.toString(new Dijkstra().dijkstra(0, graph)));
    }
}
