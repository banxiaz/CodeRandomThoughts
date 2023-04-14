package 删除字符串中的所有相邻重复项;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    //双指针法
    public String removeDuplicates2(String s) {
        char[] chars = s.toCharArray();
        int slow = 0, fast;
        for (fast = 0; fast < chars.length; fast++) {
            chars[slow] = chars[fast];
            //slow--相当于消除了连续的两个字符，因为下一个是放到slow的位置
            if (slow > 0 && chars[slow] == chars[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
        }
        return new String(chars, 0, slow);
    }


    public static void main(String[] args) {
        String s = "abbbbac";
        System.out.println(new Solution().removeDuplicates2(s));
    }
}
