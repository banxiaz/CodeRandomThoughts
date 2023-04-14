package 阶乘后的零;

public class Solution {
    public int trailingZeroes(int n) {
        // 一个数的末尾有0，那么这个数一定包含因子2和5，一个数能够分解出几个因子5，那么这个数的末尾就有几个0
        // 5的倍数一定可以贡献1个0
        // 5*5的倍数可以再贡献1个0
        // 5*5*5的倍数可以再贡献1个0 ...

        int res = 0;
        for (int i = n; i / 5 > 0; i = i / 5) {
            res += i / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(7));
    }
}
