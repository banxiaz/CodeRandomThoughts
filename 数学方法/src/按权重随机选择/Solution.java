package 按权重随机选择;

import java.util.Random;

public class Solution {
    int[] preSum;
    Random random = new Random();

    //前缀和+二分查找
    public Solution(int[] w) {
        int n = w.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        // 在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
        int target = random.nextInt(preSum[n - 1]) + 1;

        int left = 1, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
