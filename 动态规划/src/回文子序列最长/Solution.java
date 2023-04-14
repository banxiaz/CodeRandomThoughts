package 回文子序列最长;

public class Solution {
    //如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
    //如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子串的长度
    //那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //初始化：每一个单字符都是回文子序列
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("cbbd"));
    }
}
