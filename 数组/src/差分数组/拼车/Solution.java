package 差分数组.拼车;

import 差分数组.Difference;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            df.increment(trip[1], trip[2] - 1, trip[0]);
        }

        int[] res = df.result();
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }
}
