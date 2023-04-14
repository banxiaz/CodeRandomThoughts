package of14剪绳子2;

public class Solution {
    //当n>=5时，尽可能多的剪长度为3的绳子
    //当剩下的长度为4的时候，将绳子剪为长度为2的两端绳子
    //当n>=5时，3(n-3)>=2(n-2)，当n=4时，其实相当于不剪(2*2=4)
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n >= 5) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
