package of58翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        if ("".equals(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        //找到非空左右边界
        while (left <= right && (chars[left] == ' ' || chars[right] == ' ')) {
            if (chars[left] == ' ') {
                left++;
            }
            if (chars[right] == ' ') {
                right--;
            }
        }
        //如果没有一个非空字符，则直接返回""
        if (left > right) {
            return "";
        }

        int slowIndex = 0, fastIndex = left;
        while (fastIndex <= right) {
            if (fastIndex > left && chars[fastIndex] == ' ' && chars[fastIndex - 1] == ' ') {
                fastIndex++;
                continue;
            }
            chars[slowIndex++] = chars[fastIndex++];
        }

        reverse(chars, 0, slowIndex - 1);
        for (int i = 0; i < slowIndex; i++) {
            int j = i;
            while (j < slowIndex && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = j; //i会在循环中+1
        }

        return new String(chars, 0, slowIndex);
    }

    public void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }

    public static void main(String[] args) {
        System.out.println("".toCharArray().length);
        System.out.println(" ".toCharArray().length);
    }
}
