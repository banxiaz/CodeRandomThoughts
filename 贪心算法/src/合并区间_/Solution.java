package 合并区间_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    //那么按照左边界排序，排序之后局部最优：每次合并都取最大的右边界，这样就可以合并更多的区间了，整体最优：合并所有重叠的区间。
    //合并区间后左边界和右边界，作为一个新的区间，加入到result数组里就可以了。如果没有合并就把原区间加入到result数组。
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //将第一个区间加入到res
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                //取合并区间的最右边界
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                //移除最后一个区间，妙啊！！！
                res.removeLast();
                //合并区间再加入
                res.add(new int[]{start, end});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
