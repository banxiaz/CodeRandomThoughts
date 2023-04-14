package 快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //要么和为1
    //要么会重复出现，如果重复出现了，则一定不是快乐数
    //哈希表可以快速判断一个值是否出现过
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public boolean isHappy2(int n) {
        Set<Integer> record = new HashSet<>();
        while (true) {
            int sum = getNextNumber(n);
            if (sum == 1) {
                return true;
            }
            if (record.contains(sum)) {
                return false;
            } else {
                record.add(sum);
            }
            n = sum;
        }
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy2(19));
    }
}
