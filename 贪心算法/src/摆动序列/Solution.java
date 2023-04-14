package 摆动序列;

public class Solution {
    //删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值
    //只需要统计数组的峰值数量就可以了（相当于是删除单一坡度上的节点，然后统计长度）
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0; // 当前一对差值 [i+1]-[i]
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0) && preDiff >= 0) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    //dp[i][0]表示从nums[0]到nums[i]的最长下降摆动序列长度，即nums[i] < nums[i - 1]
    //dp[i][1]表示从nums[0]到nums[i]的最长上升摆动序列长度，即nums[i] > nums[i - 1]
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new Solution().wiggleMaxLength2(nums));
    }
}
