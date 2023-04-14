package 打家劫舍房屋成圈;

public class Solution {
    //核心思想为：第一个和最后一个不能同时抢。 所以：要么不抢第一个，要么不抢最后一个
    //然后取两者最大值
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //把打家劫舍代码抽离出来
        int res1 = robRange(nums, 0, nums.length - 2);
        int res2 = robRange(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
