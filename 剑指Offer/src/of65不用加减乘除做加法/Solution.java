package of65不用加减乘除做加法;

public class Solution {
    //位运算
        /*
        a   b   无进位和    进位
        0   0   0           0
        0   1   1           0
        1   0   0           0
        1   1   0           1
        无进位和n == a^b
        进位c == (a&b)<<1
        sum = a+b = n+c
         */
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1; // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
        //某一步之后： 进位 & 非进位和 一定为0，进位 ^ 非进位和 等于加法操作！
    }

    public static void main(String[] args) {
        System.out.println(new Solution().add(57, 100));
    }
}
