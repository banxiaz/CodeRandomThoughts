package 差分数组.航班预定统计;

import 差分数组.Difference;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            df.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return df.result();
    }
}
