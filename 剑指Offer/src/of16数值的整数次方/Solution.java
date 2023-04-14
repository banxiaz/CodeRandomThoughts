package of16数值的整数次方;

public class Solution {
    //递归+位运算
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n >= 0) {
            return pow(x, n);
        } else {
            //防止-2147483648转换为正数时int(-2147483648--2147483647)表示不了
            return 1 / pow(x, -(long) n);
        }
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double t = pow(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, -2147483648));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toString(Integer.MAX_VALUE, 2));
        System.out.println(Integer.toString(Integer.MIN_VALUE, 2));
    }
}
