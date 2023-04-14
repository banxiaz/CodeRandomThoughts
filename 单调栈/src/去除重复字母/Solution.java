package 去除重复字母;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            //如果当前字符重复出现，则不应该再加入
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek()) {
                //如果后面没有栈顶的这个元素了，那么这个元素即使比当前元素小，那么他也不能被删掉了
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 1. 栈顶元素比当前大
                // 2. 而且后面还有栈顶元素，当前这个为了最小字典序可以删掉并且必须被删掉
                // 3. 删掉之后这个元素就不在栈中出现了
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
