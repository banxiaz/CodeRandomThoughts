package of19正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return matchCore2(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        } else if (j == pattern.length) {
            //pattern先匹配完不等，这里没有str指向末尾的判断，因为模式串可能后面有*
            //eg: aaa == aaaa*
            return false;
        }

        if (j + 1 >= pattern.length || pattern[j + 1] != '*') {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchCore(str, pattern, i + 1, j + 1);
            } else {
                return false;
            }
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                //*=0 || *>=1
                return matchCore(str, pattern, i, j + 2) || matchCore(str, pattern, i + 1, j);
            } else {
                //*=0
                return matchCore(str, pattern, i, j + 2);
            }
        }
    }

    public boolean matchCore2(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        } else if (j == pattern.length) {
            //pattern先匹配完不等，这里没有str指向末尾的判断，因为模式串可能后面有*
            //eg: aaa == aaaa*
            return false;
        }

        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                //* = 0 || * >= 1
                return matchCore2(str, pattern, i, j + 2) || matchCore2(str, pattern, i + 1, j);
            } else {
                //* = 0
                return matchCore2(str, pattern, i, j + 2);
            }
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchCore2(str, pattern, i + 1, j + 1);
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        String s = "bbbbd";
        String p = ".*";
        System.out.println(new Solution().isMatch(s, p));
    }
}
