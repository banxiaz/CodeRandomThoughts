package 每日温度;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //单调栈：栈里面放的是下标index
    /*
    主要分析三种情况：stack.peek() 与 nums[i] > = <
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            //当前元素小于栈顶元素，当前下标入栈
            if (temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
                //当前元素等于栈顶元素，当前下标入栈
            } else if (temperatures[i] == temperatures[stack.peek()]) {
                stack.push(i);
                //当前元素大于栈顶元素，先出栈更新结果，再入栈
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    //简化后的写法
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    //暴力法
    public int[] demo(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                //只要找到第一个大于i的数，就记录位置
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Solution().demo(temperatures)));
    }
}
