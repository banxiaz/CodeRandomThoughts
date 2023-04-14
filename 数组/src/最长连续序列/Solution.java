package 最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // 用哈希表存储每个端点值对应连续区间的长度
        // Map<Integer, Integer> map = new HashMap<>();
        // int maxLen = 0;
        //
        // for (int n : nums) {
        //     if (!map.containsKey(n)) {
        //         int left = map.getOrDefault(n - 1, 0);
        //         int right = map.getOrDefault(n + 1, 0);
        //         int curLen = 1 + left + right;
        //
        //         if (curLen > maxLen) {
        //             maxLen = curLen;
        //         }
        //
        //         map.put(n, curLen);
        //         map.put(n - left, curLen);
        //         map.put(n + right, curLen);
        //     }
        // }
        // System.out.println(map);
        // return maxLen;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;
        for (int num : numSet) {
            // 只有当一个数是连续序列的第一个数的情况下才会进入内层循环
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                //每个数只进内层循环一次，时间复杂度O(n)
                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums =  {100,4,200,1,3,2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
