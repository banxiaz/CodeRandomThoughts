package 田忌赛马;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Queue<int[]> queue = new PriorityQueue<>((int[] par1, int[] par2) -> par2[1] - par1[1]);

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            // maxval 是 nums2 中的最⼤值，i 是对应索引
            int i = pair[0], maxVal = pair[1];
            if (maxVal < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则⽤最⼩值混⼀下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
