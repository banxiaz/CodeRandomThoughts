package 较难动态规划.自由之路拨转盘;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        //dp[i][j]表示 当圆盘指针指向ring[i]时，输入字符串key[j...]至少需要dp[i][j]次操作
        //从转盘任意位置到空串的次数为0
        //返回的结果是 dp[0][0]

        Map<Character, List<Integer>> charToIndex = new HashMap<>();
        int m = ring.length();
        int n = key.length();
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new LinkedList<>());
            }
            charToIndex.get(c).add(i);
        }

        int[][] dp = new int[m][n + 1]; //dp只依赖于右边部分
        for (int j = n - 1; j >= 0; j--) { //key倒序
            for (int i = 0; i < m; i++) {
                char c = key.charAt(j);
                int res = Integer.MAX_VALUE;
                // ring 上可能有多个字符 key[j]
                for (int k : charToIndex.get(c)) {
                    // 拨动指针的次数
                    int delta = Math.abs(k - i);
                    // 选择顺时针还是逆时针
                    delta = Math.min(delta, m - delta);
                    // 将指针拨到 ring[k]，继续输⼊ key[j+1..]
                    int subProblem = dp[k][j + 1];
                    // 选择「整体」操作次数最少的
                    // 加⼀是因为按动按钮也是⼀次操作
                    res = Math.min(res, 1 + delta + subProblem);
                }
                dp[i][j] = res;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "godding";
        System.out.println(new Solution().findRotateSteps(ring, key));
    }
}
