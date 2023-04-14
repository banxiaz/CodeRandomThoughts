package of15二进制中1的个数;

//判断一个数是不是2的整数次方：n&(n-1)=0是
//计算m需要改变二进制中的多少位才能得到n：m异或n，然后计算异或中有几位1
public class Solution {
    //常规解法
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    //进阶解法，n&(n-1)可以将n的最右边的1消除，每次消除一个1直到为0
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
