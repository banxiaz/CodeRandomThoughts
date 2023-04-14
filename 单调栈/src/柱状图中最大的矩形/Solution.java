package 柱状图中最大的矩形;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    // 找每个柱子左右两边第一个小于该柱子的柱子
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        // 数组扩容，在头和尾各加入一个元素0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        stack.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意 heights[i] 是和 heights[st.top()]比较，st.top()是下标
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop(); // 这个可以加，可以不加，效果一样，思路不同
                stack.push(i);
            } else {
                while (heights[i] < heights[stack.peek()]) { // 注意是while
                    int mid = stack.pop(); //需要出栈一个元素，再取栈头元素
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
