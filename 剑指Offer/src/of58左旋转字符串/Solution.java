package of58左旋转字符串;


public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        reverse(chars, 0, right);
        reverse(chars, 0, right - n);
        reverse(chars, right - n + 1, right);
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
    }
}
