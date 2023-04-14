package 最短路径.Dijkstra模板;

import java.util.*;

class State {
    int id; // id
    int distFromStart; // 从 start 节点到当前节点的距离

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

public class Dijkstra {
    public static int[] dijkstra(List<Integer>[] graph, int[][] weight, int start) {
        int V = graph.length;
        int[] disTo = new int[V]; // distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        Arrays.fill(disTo, Integer.MAX_VALUE);
        disTo[start] = 0;

        Queue<State> queue = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        queue.offer(new State(start, 0));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int curID = cur.id;
            int curDistFromStart = cur.distFromStart;

            // if (curID == target){
            //     return 到target的最短路径，算是一个优化！
            //     为什么？因为优先队列出队当前最短的距离，不可能存在经过了其他节点到当前节点的距离比这个还小
            // }

            if (curDistFromStart > disTo[curID]) {
                continue;
            }

            for (int nextNodeID : graph[curID]) {
                int distToNextNode = disTo[curID] + weight[curID][nextNodeID];
                if (distToNextNode < disTo[nextNodeID]) {
                    disTo[nextNodeID] = distToNextNode;
                    queue.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return disTo;

    }

    public static void main(String[] args) {
        List<Integer>[] graph = new List[6];
        for (int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].addAll(Arrays.asList(1, 3, 4));
        graph[1].addAll(Arrays.asList(2));
        graph[2].addAll(Arrays.asList(5));
        graph[3].addAll(Arrays.asList(5));
        graph[4].addAll(Arrays.asList(5));

        int[][] weight = new int[6][6];
        weight[0][1] = 9;
        weight[0][3] = 8;
        weight[0][4] = 5;
        weight[1][2] = 2;
        weight[2][5] = 1;
        weight[3][5] = 2;
        weight[4][5] = 6;

        System.out.println(Arrays.toString(dijkstra(graph, weight, 0)));
    }
}
