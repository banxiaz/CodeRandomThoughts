package 接雨水;

import java.util.Stack;

public class Solution {
    //单调栈，按照行方向来计算雨水
    //找每个柱子左右两边第一个大于该柱子高度的柱子
    public int trap(int[] height) {
        if (height.length <= 2) return 0; // 可以不加
        Stack<Integer> st = new Stack<>(); // 存着下标，计算的时候用下标对应的柱子高度
        st.push(0);

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[st.peek()]) {     // 情况一
                st.push(i);
            }
            if (height[i] == height[st.peek()]) {  // 情况二
                st.pop(); // 相等时弹出栈顶元素是为了保证 右边的元素一定是比他大的，这样才能直接用下标进行计算
                st.push(i);
            } else {                                // 情况三
                while (!st.empty() && height[i] > height[st.peek()]) { // 注意这里是while
                    int mid = st.pop();
                    if (!st.empty()) {
                        int h = Math.min(height[st.peek()], height[i]) - height[mid];
                        int w = i - st.peek() - 1; // 注意减一，只求中间宽度
                        sum += h * w;
                    }
                }
                st.push(i);
            }
        }
        return sum;
    }

    //双指针法，按照列方向来计算雨水
    //每一列雨水的高度，取决于该列 左侧最高的柱子和右侧最高的柱子 中最矮的那个柱子的高度。
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i == 0 || i == height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    //动态规划
    //当前位置，左边的最高高度是前一个位置的左边最高高度和本高度的最大值。
    //当前位置，左边的最高高度是后一个位置的右边最高高度和本高度的最大值。
    public int trap3(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int size = height.length;

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        // 记录每个柱子右边柱子最大高度
        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        //求和
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }
        return sum;

    }

}
