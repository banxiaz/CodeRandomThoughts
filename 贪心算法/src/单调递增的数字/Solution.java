package 单调递增的数字;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n == 0) return 0;
        char[] chars = Integer.toString(n).toCharArray();
        int start = chars.length; //防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                start = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i >= start) {
                res.append('9');
            } else {
                res.append(chars[i]);
            }
        }
        return Integer.parseInt(res.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(21421));
    }
}
