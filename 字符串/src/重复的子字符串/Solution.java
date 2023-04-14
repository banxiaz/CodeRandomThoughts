package 重复的子字符串;

public class Solution {
    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) { // 前后缀不相同了
                j = next[j - 1]; // 向前回退
            }
            if (s.charAt(i) == s.charAt(j)) { // 找到相同的前后缀
                j++;
            }
            next[i] = j;
        }
    }

    //a b c a b c a b c a b c ...
    //0 0 0 1 2 3 4 5 6 7 8 9 ...
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next, s);
        int len = s.length();
        if (next[len - 1] != 0 && len % (len - (next[len - 1])) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ababababababc";
        System.out.println(new Solution().repeatedSubstringPattern(s));
    }
}
