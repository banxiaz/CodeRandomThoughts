package 俄罗斯套娃信封问题;

import java.util.Arrays;

public class Solution {
    //leetcode会超时，改用二分查找才能通过
    public int maxEnvelopes(int[][] envelopes) {
        //先对宽度升序排序，遇到相同宽度时，按照高度降序排序，之后在高度上求取 最长递增子序列（可以不连续）
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
