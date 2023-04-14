package 字符串的排列;

public class Solution {
    //s1 的排列之一是 s2 的 子串
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        for (int i = 0; i < s1Len; i++) {
            s1Cnt[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int i = 0; i < s2Len; i++) {
            s2Cnt[s2.charAt(i) - 'a']++;
            while (s2Cnt[s2.charAt(i) - 'a'] > s1Cnt[s2.charAt(i) - 'a']) {
                s2Cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (i - left + 1 == s1Len) {
                return true;
            }
        }
        return false;
    }
}
