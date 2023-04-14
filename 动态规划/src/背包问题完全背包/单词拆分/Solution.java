package 背包问题完全背包.单词拆分;

import java.util.List;

public class Solution {
    //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词
    //单词是有序的，即求排列数，先背包，再物品
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) { //背包 = 字符串长度
            for (int j = 0; j < i; j++) { //物品 = 子串
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
