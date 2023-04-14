package 复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        backtracking(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    public void backtracking(String s, int startIndex, int pointNum) {
        // 逗点数量为3时，分隔结束
        if (pointNum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 判断 [startIndex,i] 这个区间的子串是否合法
            if (isValid(s, startIndex, i)) {
                //在str的后⾯插⼊⼀个逗点
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backtracking(s, i + 2, pointNum);
                pointNum--; // 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                /*
                不合法，直接结束本层循环
                为什么不用continue？因为不合法的数字串作为另一个子串时，这个另一个串也不合法了，根本不用继续判断，直接跳过
                 */
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    // 不合法的情况有：
    //- 以0开头的多个数字不合法
    //- 有非正整数字符不合法
    //- 如果大于255了不合法
    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的多位数字不合法，但是一个0合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}
