package of50第一个只出现一次的字符;

import java.util.Arrays;

public class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] count = new int[26];
        Arrays.fill(count, -1);
        //-1表示没有出现过 -2表示重复出现过 >=0表示只出现过一次
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == -1) {
                count[index] = i;
            } else if (count[index] >= 0) {
                count[index] = -2;
            }
        }
        int minIndex = s.length();
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 0 && count[i] < minIndex) {
                minIndex = count[i];
            }
        }
        return minIndex == s.length() ? ' ' : s.charAt(minIndex);
    }


    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
