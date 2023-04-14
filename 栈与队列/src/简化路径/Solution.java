package 简化路径;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        System.out.println(Arrays.toString(strings));
        Stack<String> stack = new Stack<>();
        for (String str : strings) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        String ans = "";
        if (stack.isEmpty()) {
            ans = "/";
        } else {
            while (!stack.isEmpty()) {
                ans = "/" + stack.pop() + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "/home//foo";
        System.out.println(new Solution().simplifyPath(s));
    }
}
