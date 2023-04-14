package of64一相加到n;

public class Solution {
    public int sumNums(int n) {
        //短路运算符
        //当n=1时，x=false，后面的不会执行
        //当n>1时，后面的会执行
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums1(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums1(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumNums1(100));
    }
}
