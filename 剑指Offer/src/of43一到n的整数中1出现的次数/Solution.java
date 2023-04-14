package of43一到n的整数中1出现的次数;

public class Solution {
    //整体思路：分别计算n中每一位上1出现的次数，然后累加。
    //其中每一位1出现的次数 = [在高位中有几个完整的循环] + [当前位没有 || 当前位不完整的循环 || 当前位完整的循环]
    //个位：每10循环1次，[0-9]
    //十位：每100循环10次，[10-19]
    //百位：每1000循环100次，[100-199]
    //千位：每10000循环1000次，[1000-1999]
    //万位：每100000循环10000次，[10000-19999] ...

    public int countDigitOne(int n) {
        int ori_n = n;
        int res = 0;
        long base = 1;
        while (n > 0) {
            int one_place = n % 10; //当前位
            int others_place = n / 10; //高位

            if (one_place == 0) {
                res += others_place * base;
            } else if (one_place == 1) {
                res += others_place * base + (ori_n % base + 1);
            } else {
                res += others_place * base + 1 * base;
            }

            base *= 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(123));
    }
}
