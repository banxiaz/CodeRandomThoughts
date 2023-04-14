package of47礼物的最大价值;

public class Solution {
    public int maxValue(int[][] grid) {
        //dp[i][j]表示到达(i,j)可以拿到的礼物的最大价值
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        int count = 0;
        //dp初始化
        for (int i = 0; i < row; i++) {
            count += grid[i][0];
            dp[i][0] = count;
        }
        count = 0;
        for (int j = 0; j < column; j++) {
            count += grid[0][j];
            dp[0][j] = count;
        }
        //递推公式
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(new Solution().maxValue(grid));
    }
}
