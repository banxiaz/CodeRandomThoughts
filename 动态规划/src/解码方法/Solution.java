package 解码方法;

public class Solution {
    // 1. 如果当前位置不为0，则只使用当前位置可以被解码为一位，dp[i] += dp[i - 1]
    // 2. 如果连续使用两位，则两位中第一个数字一定不能为0且在26之内，dp[i] += dp[i - 2]
    // 3. 如果当前位置不满足上述任何一种情况，维持0不变
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
