package of56数组中数字出现的次数;

public class Solution {
    //0^n=n n^n=0
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
        //找到最低位第一个为1的位置
        while ((n & m) == 0) {
            m <<= 1;
        }

        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }
}
