package of13机器人的运动范围;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || getSum(i, j) > k || visited[i][j]) {
            return 0;
        }

        //进入的格子不能重复进入
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited)
                + dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited);
    }

    public int getSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 0));
    }
}
