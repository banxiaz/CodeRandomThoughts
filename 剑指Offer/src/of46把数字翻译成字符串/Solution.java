package of46把数字翻译成字符串;

public class Solution {
    //类似于青蛙跳台阶问题：每次可以跳一阶或者两阶（需要满足10<=n<=25）
    //长度为i的数字翻译成字符串的数量为dp[i]
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }

        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];

        dp[1] = 1;
        int key = (chars[0] - '0') * 10 + (chars[1] - '0');
        if (key >= 10 && key <= 25) {
            dp[2] = 2;
        } else {
            dp[2] = 1;
        }

        for (int i = 3; i <= len; i++) {
            int n = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if (n >= 10 && n <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
