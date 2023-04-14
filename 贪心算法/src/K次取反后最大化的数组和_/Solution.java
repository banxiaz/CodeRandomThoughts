package K次取反后最大化的数组和_;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue)
                .toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //如果k还有剩余
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }

    //排序+一次遍历
    //如果有负数，优先反转最小的负数
    //如果有正数，将最小的正数不停翻转
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
            minVal = Math.min(minVal, nums[i]);
        }
        if (k % 2 == 1) {
            sum -= 2 * minVal;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -3, -1, 5, -4};
        System.out.println(new Solution().largestSumAfterKNegations2(nums, 2));


    }
}
