package of59滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    int peek() {
        return deque.peek();
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }

        res[index++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[index++] = myQueue.peek();
        }
        return res;
    }
}
