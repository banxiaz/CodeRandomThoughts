package 分割回文串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) { //for循环是一个树层中的==横向
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                backtracking(s, i + 1); //一个树枝向下递归==纵向
                path.remove(path.size() - 1);
            } else {
                //不是回文直接跳过这个分支，不再向下遍历
                continue;
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaa"));
    }
}
