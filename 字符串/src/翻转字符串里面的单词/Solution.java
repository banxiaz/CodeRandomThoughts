package 翻转字符串里面的单词;

public class Solution {
    //时间复杂度O(n) 空间复杂的O(n)
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        //找到非空左右边界
        while ((chars[left] == ' ' || chars[right] == ' ') && left <= right) {
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

        //双指针法移除字符串中间的空格，注意 fastIndex > left 的目的是不判断第一个字符，因为第一个字符肯定是非空
        int slowIndex = 0, fastIndex = left;
        while (fastIndex <= right) {
            if (chars[fastIndex] == ' ' && chars[fastIndex - 1] == ' ' && fastIndex > left) {
                fastIndex++;
                continue;
            }
            chars[slowIndex++] = chars[fastIndex++];
        }
        //slowIndex为字符串右边界（不包含）
        reverse(chars, 0, slowIndex - 1);
        for (int i = 0; i < slowIndex; i++) {
            int j = i;
            while (j < slowIndex && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = j; //i会+1
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
        String s = "  the sky is blue  ";
        System.out.println(new Solution().reverseWords(s));
    }
}
