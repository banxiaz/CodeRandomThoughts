package of61扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++; //统计大小王的数量
            } else if (nums[i] == nums[i + 1]) {
                return false; //如果有重复，提前返回false
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
