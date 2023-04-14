package 区间列表的交集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int a = firstList[i][0], b = firstList[i][1];
            int x = secondList[j][0], y = secondList[j][1];
            int left = Math.max(a, x);
            int right = Math.min(b, y);
            if (left <= right) {
                int[] tmp = {left, right};
                res.add(tmp);
            }
            if (y >= b) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
