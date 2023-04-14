package 组合问题电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //设置全局列表存储最后的结果
    List<String> result;
    //每次迭代获取一个字符串，涉及大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder path;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        path = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, numString, 0);
        return result;
    }

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    //num理解为遍历了几个数了
    public void backtracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            result.add(path.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backtracking(digits, numString, num + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("233"));
        System.out.println("233".length());
    }
}
