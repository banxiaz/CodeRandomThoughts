package 背包问题完全背包.一维数组;

public class Solution {
    //对于纯完全背包问题，其for循环的先后循环是可以颠倒的！
    //如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    //完全背包问题：背包容量顺序遍历
    public void testCompletePack() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { //物品
            for (int j = weight[i]; j <= bagWeight; j++) { //背包正序
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }

    public static void main(String[] args) {
        new Solution().testCompletePack();
    }
}
