package 背包问题01背包.二维数组;

public class Solution {
    /**
     * 从每一件物品开始，不断增加背包的容量
     * 对于当前物品，可以放也可以不放，去两者的最大值
     *
     * @param weight
     * @param value
     * @param bagsize
     */
    public void weightbagproblem(int[] weight, int[] value, int bagsize) {
        int[][] dp = new int[weight.length][bagsize + 1];
        for (int j = weight[0]; j <= bagsize; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagsize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[weight.length - 1][bagsize]);
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        new Solution().weightbagproblem(weight, value, bagsize);
    }
}
