package 根据身高重建队列;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    //所以先从大到小按照h排个序，再来贪心k
    //1.先按身高由大到小排序，其中身高相同时，k小的排前面
    //2.依次遍历排好序的数组，将元素插入到索引为k的位置
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            //正序
            if (a[0] == b[0]) return a[1] - b[1];
            //逆序
            return b[0] - a[0];
        });
        System.out.println(Arrays.deepToString(people));

        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            //index,e
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
