package 字符串转换整数;

public class Solution {
    public int myAtoi(String s) {
        int sign = 1, ans = 0, index = 0;
        char[] array = s.toCharArray();
        while (index < array.length && array[index] == ' ') {
            index++;
        }
        if (index < array.length && (array[index] == '-' || array[index] == '+')) {
            sign = array[index++] == '-' ? -1 : 1;
        }
        while (index < array.length && array[index] <= '9' && array[index] >= '0') {
            int digit = array[index++] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                //写成 ans * 10 + digit > Integer.MAX_VALUE 可能会导致越界
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        // int32 的数值范围是 [-2147483648, 2147483647]
        System.out.println(new Solution().myAtoi("-2147483648"));
    }
}
