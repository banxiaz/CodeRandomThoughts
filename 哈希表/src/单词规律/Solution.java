package 单词规律;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strS = s.split(" ");
        if (pattern.length() != strS.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = strS[i];

            //key在，但不对应
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(str)) {
                    return false;
                }
            } else {
                //key不在，但是值已经存在
                if (map.containsValue(str)) {
                    return false;
                } else {
                    //key不在，值也不在
                    map.put(ch, str);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(new Solution().wordPattern(pattern, s));
    }
}
