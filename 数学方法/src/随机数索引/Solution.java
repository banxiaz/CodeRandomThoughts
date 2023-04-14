package 随机数索引;

import java.util.Random;

public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    //遍历nums，当我们第 i 次遇到值为 target 的元素时，随机选择区间 [0,i) 内的一个整数，如果其等于 0，则将返回值置为该元素的下标，否则返回值不变。

    public int pick(int target) {
        int res = 0;
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++; //记录遇到target的次数
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
