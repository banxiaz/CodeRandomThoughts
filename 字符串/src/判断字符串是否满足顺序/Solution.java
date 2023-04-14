package 判断字符串是否满足顺序;

public class Solution {
    //template为匹配模板，str为待判断字符串
    public boolean check(String template, String str) {
        int index = 0; //指向template
        for (int i = 0; i < str.length(); i++) {
            if (index == template.length()) {
                return true;
            }
            if (template.charAt(index) == str.charAt(i)) {
                index++;
            }
        }
        return index == template.length();
    }

    public static void main(String[] args) {
        String template = "failed";
        String str = "faileeeeeeed";
        System.out.println(new Solution().check(template, str));
    }
}
