package 编辑距离.编辑距离;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //相同的话，不用编辑，那就看都少一位的时候编辑距离是多少
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不同的话，分3种情况
                    //1.word1删除一个元素 dp[i][j] = dp[i - 1][j] + 1
                    //2.word2删除一个元素 dp[i][j] = dp[i][j - 1] + 1
                    //3.word1替换word1[i - 1]，使其与word2[j - 1]相同 dp[i][j] = dp[i - 1][j - 1] + 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
