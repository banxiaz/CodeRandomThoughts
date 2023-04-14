package 两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        //map存储<元素值，下标>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
