package 吃葡萄;

import java.util.Arrays;

public class Solution {
    //向下取整 M/N
    //向上取整 [M+(N-1)]/N
    public long solution(long a, long b, long c) {
        long[] nums = new long[]{1, b, c};
        Arrays.sort(nums);
        long sum = a + b + c;

        // 能够构成三⻆形，可完全平分
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }
        // 不能构成三⻆形，平分最⻓边的情况/
        if (2 * (nums[0] + nums[1]) < nums[2]) {
            return (nums[2] + 1) / 2;
        }
        // 不能构成三⻆形，但依然可以完全平分的情况
        return (sum + 2) / 3;
    }
}
