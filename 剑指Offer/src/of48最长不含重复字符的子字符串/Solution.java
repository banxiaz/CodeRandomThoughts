package of48最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            // 维持一个每个元素只出现一次的窗口
            // left:包含了重复元素的区间肯定不在考虑范围内，就要一直移动left指针
            while (set.contains(chars[i])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[i]);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                res = Math.max(res, i - left + 1);
            } else {
                while (set.contains(chars[i])) {
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring2(s));
    }
}
