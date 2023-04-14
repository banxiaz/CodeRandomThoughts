package 最短路径.网络延迟时间;

import java.util.Arrays;

public class Solution {
    private final static int INF = Integer.MAX_VALUE;

    //从1到n有n个节点，起点为k，times[i] = (ui, vi, wi)，ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i <= n; i++) {
            graph[i][i] = 0;
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int val = time[2];
            graph[from][to] = val;
        }

        System.out.println(Arrays.deepToString(graph));
        for (int item = 1; item <= n; item++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][item] != INF && graph[item][j] != INF && graph[i][item] + graph[item][j] < graph[i][j]) {
                        graph[i][j] = graph[i][item] + graph[item][j];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(graph));

        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (graph[k][i] == INF) {
                //不可达
                return -1;
            }
            res = Math.max(res, graph[k][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(new Solution().networkDelayTime(times, 4, 2));
    }
}
