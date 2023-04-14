package 无重叠区间_;

import java.util.Arrays;
import java.util.Comparator;


public class Solution {
    //按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的
    //按照右边界排序，从左向右记录非交叉区间的个数
    //最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        // 按照区间右边界排序
        // Arrays.sort(intervals, (o1, o2) -> {
        //     if (o1[1] != o2[1]) {
        //         return Integer.compare(o1[1], o2[1]);
        //     } else {
        //         return Integer.compare(o1[0], o2[0]);
        //     }
        // });
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1; // 记录非交叉区间的个数
        int edge = intervals[0][1]; // 记录区间分割点
        for (int i = 1; i < intervals.length; i++) {
            //非交叉区间的个数
            if (edge <= intervals[i][0]) {
                count++;
                //更新右边界
                edge = intervals[i][1];
            }
        }
        //区间总数减去非交叉区间的个数就是需要移除的区间个数了
        return intervals.length - count;
    }
}
