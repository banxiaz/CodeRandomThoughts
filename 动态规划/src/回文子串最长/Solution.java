package 回文子串最长;

public class Solution {
    public String longestPalindrome(String s) {
        //dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是 dp[i][j]为true，否则为false
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 >= maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
