package 有效的括号;

import java.util.Stack;

public class Solution {
    // 使用栈
    // 1.如果是左括号，则将对应的右括号入栈
    // 2.如果是右括号，且与栈顶元素对应，消掉当前右括号，继续
    // 3.如果是右括号且不匹配，false
    // 4.如果是右括号但栈空，false
    // 5.最后判断栈是否为空
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
