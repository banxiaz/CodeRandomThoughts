package 正则表达式匹配;

public class Solution {
    /*
    f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
    - if p[j] != '*'
        - f[i-1][j-1] matches(s[i], p[j])
        - false       otherwise
    - otherwise
        - f[i][j-2] or f[i-1][j] matches(s[i], p[j-1]) 相当于 *=0 or *>=1
        - f[i][j-2]              otherwise  相当于 *=0 次
     */

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //dp[i][j]表示以 下标i-1为结尾的s 和 以下标j-1为结尾的p 能否匹配，这里是错位定义
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case: s为空串，匹配成功只有两种情况：
        // - p 也为空串
        // - p 的形式为：#*#*#*...
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (matches(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (matches(s.charAt(i - 1), p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(char a, char b) {
        if (a == b) {
            return true;
        }
        return a == '.' || b == '.';
    }
}
