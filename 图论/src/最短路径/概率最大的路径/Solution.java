package 最短路径.概率最大的路径;

import java.util.*;

class State {
    int id;
    double probFromStart;

    public State(int id, double probFromStart) {
        this.id = id;
        this.probFromStart = probFromStart;
    }
}

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{(double) to, weight});
            graph[to].add(new double[]{(double) from, weight});
        }
        return dijkstra(start, end, graph);
    }

    public double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, -1);
        // base case，start 到 start 的概率就是 1
        probTo[start] = 1;

        Queue<State> queue = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));
        queue.offer(new State(start, 1));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curID = curState.id;
            double curProFromStart = curState.probFromStart;
            if (curID == end) {
                return curProFromStart;
            }

            if (curProFromStart < probTo[curID]) {
                // 已经有⼀条概率更⼤的路径到达 curNode 节点了
                continue;
            }

            // 看看从 curNode 达到 nextNode 的概率是否会比probTo[nextNodeID]更⼤
            for (double[] neighbor : graph[curID]) {
                int nextNodeID = (int) neighbor[0];
                double probToNextNode = probTo[curID] * neighbor[1];
                if (probTo[nextNodeID] < probToNextNode) {
                    probTo[nextNodeID] = probToNextNode;
                    queue.offer(new State(nextNodeID, probToNextNode));
                }
            }
        }
        return 0.0;
    }
}
