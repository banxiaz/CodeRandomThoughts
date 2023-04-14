package 爱吃香蕉的珂珂;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 1;
        for (int pile : piles) {
            maxValue = Math.max(maxValue, pile);
        }

        int left = 1; //吃香蕉的最小速度为1
        int right = maxValue; //吃香蕉的最大速度为maxValue
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!possible(piles, h, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int pile : piles) {
            time += (pile - 1) / K + 1; //向上取整数，不足1小时按1小时算
        }
        return time <= H;
    }
}
