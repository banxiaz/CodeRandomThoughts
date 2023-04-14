package 视频拼接;

import java.util.Arrays;

class Solution2 {
    //还是基于贪心，先排序，在排序的顺序中找到下一个左端点小于当前右端点，并且右端点大于当前右端点的片段
    //有多个序列满足上述条件时，选择右端点尽可能大的
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        System.out.println(Arrays.deepToString(clips));
        if (clips[0][0] != 0) {
            // 第一个片段都不以0开始，肯定拼不成
            return -1;
        }

        int i = 0, curEnd = 0, nextEnd = 0, res = 0;
        int n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            while (i < n && clips[i][0] <= curEnd) {
                //多个序列满足左端点<curend且右端点>curend时，选择右端点最大的
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return res;
            }
        }
        return -1;
    }
}

