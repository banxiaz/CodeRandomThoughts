package 编辑距离.判断子序列;

public class Solution {
    //判断 s 是否为 t 的子序列 s<t
    //dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]
    //这一类问题，基本是要分析两种情况，
    // s[i - 1] 与 t[j - 1]相等
    // s[i - 1] 与 t[j - 1]不相等
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，
                    //那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1];
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        if (dp[s.length()][t.length()] == s.length()) {
            return true;
        } else {
            return false;
        }
    }

    //双指针
    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int slowIndex = 0, fastIndex = 0;
        for (fastIndex = 0; fastIndex < t.length(); fastIndex++) {
            if (s.charAt(slowIndex) == t.charAt(fastIndex)) {
                slowIndex++;
            }
            if (slowIndex == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="abc";
        String t="azbzcz";
        System.out.println(new Solution().isSubsequence(s,t));
    }
}
