package of40最小的k个数大根堆;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k <= 0) {
            return new int[]{};
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.offer(num);
            }
        }

        int[] res = new int[k];
        int index = 0;
        for (int num : queue) {
            res[index++] = num;
        }
        return res;
    }
}
