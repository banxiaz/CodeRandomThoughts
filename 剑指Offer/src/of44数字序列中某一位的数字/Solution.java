package of44数字序列中某一位的数字;

public class Solution {
    public int findNthDigit(int n) {
        int digit = 1;  //数字的位数
        long start = 1; //每digit位数的起始数字 eg:1 10 100 1000
        long count = 9; //数位数量=9 * start * digit
        //确定n所在的数字的位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //确定n所在的数字
        long num = start + (n - 1) / digit;
        //确定n是num中的哪一位数，并返回结果
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
