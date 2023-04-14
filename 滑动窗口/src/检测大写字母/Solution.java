package 检测大写字母;

public class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        char flag = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }
        //大写字母数量为0 或者 等于单词长度
        if (count == word.length() || count == 0) {
            return true;
        }
        //大写字母数量等于1且只有首字母为大写
        if (count == 1 && flag >= 'A' && flag <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA is the cancer of the world"));
    }
}
