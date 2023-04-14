package 最短路径.最小体力消耗路径;

import java.util.*;

class State {
    int x, y;
    int effortFromStart;

    public State(int x, int y, int effortFromStart) {
        this.x = x;
        this.y = y;
        this.effortFromStart = effortFromStart;
    }
}

public class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Dijkstra 算法，计算 (0, 0) 到 (m - 1, n - 1) 的最⼩体⼒消耗
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // 定义：从 (0, 0) 到 (i, j) 的最⼩体⼒消耗是 effortTo[i][j]
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        Queue<State> queue = new PriorityQueue<>((a, b) -> a.effortFromStart - b.effortFromStart);
        queue.offer(new State(0, 0, 0));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffort = curState.effortFromStart;

            //提前到达终点
            if (curX == m - 1 && curY == n - 1) {
                return curEffort;
            }

            //当次是无效节点，距离已经在前面更新了
            if (curEffort > effortTo[curX][curY]) {
                continue;
            }

            //对当前节点进行松弛操作
            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNextNode = Math.max(effortTo[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    queue.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }

    //返回(x, y)点的上下左右相邻的坐标
    public List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue; //越界
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new Solution().minimumEffortPath(matrix));
    }
}
