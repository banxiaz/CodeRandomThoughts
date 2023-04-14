package 滑动窗口最大值单调队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//单调队列：需要维护有可能成为窗口里最大值的元素就可以了，同时保证队里的元素数值是由大到小的。
class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出，如果不相等不用管
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素从出口到入口单调递减
    //比如此时队列元素[3,1]  2将要入队，比1大，所以1弹出，此时队列：[3,2]
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast(); //这里将非最大值的后面的数弹出去
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }

}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除时判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 3)));
    }
}
