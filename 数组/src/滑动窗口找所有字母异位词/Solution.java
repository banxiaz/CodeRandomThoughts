package 滑动窗口找所有字母异位词;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //s 和 p 仅包含小写字母
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;

        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            //1.s出现了p中没有的字符，由于子串连续，一直移动left到大于right
            //2.s出现的次数大于p中的次数了，由于子串连续，一直移动left到出现次数不大于p
            while (sCnt[curRight] > pCnt[curRight]) {
                sCnt[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == m) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcaba";
        String p = "ab";
        System.out.println(new Solution().findAnagrams(s, p));
    }
}
