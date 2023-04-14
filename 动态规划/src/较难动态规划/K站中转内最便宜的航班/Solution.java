package 较难动态规划.K站中转内最便宜的航班;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 哈希表记录每个点的⼊度
    // to -> [from, price]
    HashMap<Integer, List<int[]>> inDegree;
    int src, dst;
    //备忘录
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //从起点 src 出发，k 步之内（⼀步就是⼀条边）到达节点 s 的最小路径权重为 dp(s, k)
        this.src = src;
        this.dst = dst;
        buildGraph(flights);
        // 初始化备忘录，全部填⼀个特殊值
        memo = new int[n][k + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -520);
        }


        return dp(dst, k + 1);
    }

    // 定义：从 src 出发，k 步之内到达 s 的最短路径权重
    public int dp(int s, int k) {
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }

        // 查备忘录，防⽌冗余计算
        if (memo[s][k] != -520) {
            return memo[s][k];
        }

        int res = Integer.MAX_VALUE;
        if (inDegree.containsKey(s)) {
            for (int[] v : inDegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的⼊度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过⽆解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

    public void buildGraph(int[][] flights) {
        inDegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            inDegree.putIfAbsent(to, new LinkedList<>());
            inDegree.get(to).add(new int[]{from, price});
        }
    }
}
