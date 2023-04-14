package 最小的覆盖子串入门题;

import java.util.HashMap;

public class Solution {
    HashMap<Character, Integer> ori = new HashMap<>();
    HashMap<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        //统计t中各字符出现的次数
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        for (int r = 0; r < s.length(); r++) {
            if (ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Character c : ori.keySet()) {
            if (cnt.getOrDefault(c, 0) < ori.get(c)) {
                return false;
            }
        }
        return true;
    }
}
