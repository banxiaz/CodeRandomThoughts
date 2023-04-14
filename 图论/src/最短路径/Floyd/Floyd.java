package 最短路径.Floyd;

import java.util.Arrays;

// https://blog.csdn.net/m0_46272108/article/details/108919125
public class Floyd {
    public static final int INF = Integer.MAX_VALUE;

    public int[][] floyd(int[][] graph, int n) {
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            dis[i] = Arrays.copyOf(graph[i], n);
        }

        //要让任意两点之间的路程变短，只能引入第3个点，相当于动态规划
        //一开始只引入0，之后在0的基础上引入1，在此基础上再引入2，在此基础上再引入3...
        //通过不断引入新的点，动态更新最短距离
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][k] != INF && dis[k][j] != INF && dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 2, 6, 4},
                {INF, 0, 3, INF},
                {7, INF, 0, 1},
                {5, INF, 12, 0}};
        System.out.println(Arrays.deepToString(new Floyd().floyd(graph, 4)));
    }
}
