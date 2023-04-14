package 字符串匹配KMP;

public class Solution {
    //暴力法
    public int strStr22222(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    //KMP算法：当出现字符串不匹配时，可以知道一部分之前已经匹配的文本内容，从而利用这些信息避免从头再去做匹配
    //KMP算法最大的特点是：消除了主串指针的回溯，模式串指针有规律（依据next数组）回退，提高了字符串的匹配效率
    //KMP算法在模式串有相同前后缀的时候可以加速匹配，如果模式串没有相同前后缀对效率没有多大提升
    //【前缀一定包含第一个字符，后缀一定包含最后一个字符】前缀表记录的是相同前后缀中的最大长度（也就是说前后有一部分子串一模一样）
    //某个字符失配时，前缀表会告诉你下一步匹配中，模式串应该跳到哪个位置
    //前缀表：记录下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀（相同就是完全一样）
    //前缀表（不减一）next记录包括i的最长相等前后缀的长度
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        // i从来没有回溯过，j是模式串中用来做比较的下标
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) { // 不匹配
                j = next[j - 1]; // j 寻找之前匹配的位置，移动j的位置就行了
            }
            if (haystack.charAt(i) == needle.charAt(j)) { // 匹配，j和i同时向后移动
                j++; // i的增加在for循环中
            }
            if (j == needle.length()) { // 文本串s里出现了模式串t，匹配到末尾
                return i - next.length + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        int j = 0; //j记录的是【当前比较】已经匹配的最长前后缀的长度
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) { // 前后缀不相同了
                j = next[j - 1]; // 向前回退
            }
            if (s.charAt(i) == s.charAt(j)) { // 找到相同的前后缀
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
