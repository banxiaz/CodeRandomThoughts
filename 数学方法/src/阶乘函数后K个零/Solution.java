package 阶乘函数后K个零;

public class Solution {
    public int preimageSizeFZF(int k) {
        //使用二分查找找左右边界，满足条件的最小的n和满足条件最大的n
        return (int) (rightBound(k) - leftBound(k));
    }

    public long leftBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (trailingZeroes(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long rightBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (trailingZeroes(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //返回n!中末尾有几个0
    public long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }
}
