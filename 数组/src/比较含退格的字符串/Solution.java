package 比较含退格的字符串;

public class Solution {
    //从后向前遍历
    public boolean backspaceCompare(String s, String t) {
        int sSkipNum = 0, tSkipNum = 0;
        int i = s.length() - 1, j = t.length() - 1;
        while (true) {
            //从后向前，消除s中的#，定位到待遍历的地方
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkipNum++;
                } else {
                    if (sSkipNum > 0) sSkipNum--;
                    else break;
                }
                i--;
            }
            //从后向前，消除t中的#，定位到待遍历的地方
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkipNum++;
                } else {
                    if (tSkipNum > 0) tSkipNum--;
                    else break;
                }
                j--;
            }
            //如果有一个先遍历完了，剩余的也不用比较了
            if (i < 0 || j < 0) break;
            //如果有字符不等
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        if (i == -1 && j == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(new Solution().backspaceCompare(s, t));
    }
}
