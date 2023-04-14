package 用最少数量的箭引爆气球_;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //按照起始位置排序，那么就从前向后遍历气球数组，靠左尽可能让气球重复
    //如果气球重叠了，重叠气球中右边边界的最小值 之前的区间一定需要一个弓箭，且只需要一个弓箭
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        // Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 1; // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {  //球i和气球i-1不挨着，注意这里不是>=
                count++;                            // 需要一支箭
            } else {                                //球i和气球i-1挨着
                // 更新重叠气球最小右边界，这个边界之前的都可以用一只箭
                // 直接修改point[i][1]
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int count = 1;
        int minRightBoundary = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRightBoundary) {
                count++;
                minRightBoundary = points[i][1];
            } else {
                minRightBoundary = Math.min(minRightBoundary, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new Solution().findMinArrowShots(points));
    }
}
