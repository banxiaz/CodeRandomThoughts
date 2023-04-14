package 编辑距离.求子序列个数;

public class Solution {
    //这一类问题，基本是要分析两种情况
    // s[i - 1] 与 t[j - 1]相等
    // s[i - 1] 与 t[j - 1] 不相等
    /*
    dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
    或者说：字符串i-1的s可以随便删除元素（当然可以删成空字符串），出现以j-1的t的个数为dp[i][j]。

    1：为啥状态方程是： s[i-1] == t[j-1] 时 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                     s[i-1] != t[j-1] 时 dp[i][j] = dp[i-1][j]
    - 先看s[i-1] == t[j-1] 时，以s = "rara" t = "ra" 为例，当i = 3, j = 1时，s[i] == t[j]。
    此时分为2种情况，s串用最后一位的a + 不用最后一位的a。
    如果用s串最后一位的a,那么t串最后一位的a也被消耗掉，此时的子序列其实=dp[i-1][j-1]
    如果不用s串最后一位的a，那就得看"rar"里面是否有"ra"子序列的了，就是dp[i-1][j]
    所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

    - 再看s[i] != t[j] 比如 s = "rarb" t = "ra" 还是当i = 3, j = 1时，s[i] != t[j]
    此时显然最后的b想用也用不上啊。所以只能指望前面的"rar"里面是否有能匹配"ra"的
    所以此时dp[i][j] = dp[i-1][j]
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new Solution().numDistinct(s, t));
    }
}
