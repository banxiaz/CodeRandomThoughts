package 在D天内送达包裹的能力;


import java.util.Arrays;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!possible(weights, days, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //以最低容量为capacity，能否在days天运完货物weights？
    public boolean possible(int[] weights, int days, int capacity) {
        int needDays = 1;
        int cur = 0;
        for (int weight : weights) {
            cur += weight;
            if (cur > capacity) {
                needDays++;
                cur = weight;
            }
        }
        return needDays <= days;
    }
}
