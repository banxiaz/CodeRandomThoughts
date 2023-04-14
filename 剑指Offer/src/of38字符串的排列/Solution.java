package of38字符串的排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res=new LinkedList<>();
    StringBuilder path=new StringBuilder();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];

        backtracking(chars, used);

        String[] strings = new String[res.size()];
        int i = 0;
        for (String str : res) {
            strings[i++] = str;
        }
        return strings;
    }

    public void backtracking(char[] s, boolean[] used) {
        if (path.length() == s.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i] == s[i - 1] && used[i-1] == false) { //防止被重复选取
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.append(s[i]);
            backtracking(s, used);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    //此题有重复元素
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(Arrays.toString(new Solution().permutation(s)));
    }
}
