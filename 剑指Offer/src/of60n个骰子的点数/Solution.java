package of60n个骰子的点数;

import java.util.Arrays;

public class Solution {
    /*
    1. n个骰子的点数范围为[n,6n]，数量为6n-n+1=5n种。
    2. 将每个骰子的点数看作独立情况，共有6^n种点数组合。
     */

    //投掷n枚骰子，点数为k出现的次数
    public int getCount(int n, int k) {
        if (n == 1) {
            if (k <= 0 || k >= 7) {
                return 0;
            } else {
                return 1;
            }
        }
        return getCount(n - 1, k - 1) + getCount(n - 1, k - 2)
                + getCount(n - 1, k - 3) + getCount(n - 1, k - 4)
                + getCount(n - 1, k - 5) + getCount(n - 1, k - 6);
    }

    public double[] dicesProbability(int n) {
        //dp[i][j]表示投掷完i轮后，点数j出现的次数
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur <= 0) { //保证j > cur
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - cur];
                }
            }
        }

        double all = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        int index = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[index++] = dp[n][i] / all;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(2)));
    }
}
