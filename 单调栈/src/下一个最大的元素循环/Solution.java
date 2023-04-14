package 下一个最大的元素循环;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //有一种方法：将nums拼接在nums后面，再将结果去原来的一半大小
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }

        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.empty() && nums[i % size] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % size];//更新result
                stack.pop();//弹出栈顶
            }
            stack.push(i % size);
        }
        return res;
    }
}
