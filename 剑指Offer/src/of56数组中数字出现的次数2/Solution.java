package of56数组中数字出现的次数2;

public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) { //0存储的是低位
                count[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0, m = 3;
        //应该逆序进行res恢复，31存储的是高位，高位需要不断进位
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
