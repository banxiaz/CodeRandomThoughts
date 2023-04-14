package 和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //前缀和 -> 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int want = sum - k;
            if (preSum.containsKey(want)) {
                res += preSum.get(want);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
