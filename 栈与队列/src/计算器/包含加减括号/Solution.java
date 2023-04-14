package 计算器.包含加减括号;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < s.length() && isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res); //将前面的结果入栈，并重新开始计算
                res = 0;
                stack.push(sign); //将前面的符号入栈并重新开始计算
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String s = "-(2-3)";
        System.out.println(new Solution().calculate(s));
    }
}
