package 背包问题01背包.分割等和子集;

public class Solution {
    /*
    dp[j]表示 背包总容量是j，最大可以凑成的子集总和为dp[j]
    dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
    物品是i，重量是nums[i]，价值也是nums[i]，背包体积是sum/2。
    传统的「0−1 背包问题」要求选取的物品的重量之和不能超过背包的总容量，
    这道题则要求选取的数字的和恰好等于整个数组的元素和的一半。
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        //因为dp[i]<=i，即背包里面装的物品不大于容量，如果最后刚好等于容量，则表示能找到一种组合。
        if (dp[target] == target) {
            return true;
        }
        return false;
    }
}
