package 下一个更大的元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        //存储nums1中的[值，下标]
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }

        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            //当前元素小于栈顶元素
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (hashMap.containsKey(nums2[stack.peek()])) {
                        Integer index = hashMap.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
