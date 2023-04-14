package of17打印从1到最大的n位数;

import java.util.Arrays;


public class Solution {
    //常规解法，不考虑大数问题
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    //大数打印解法,生成的列表实际上是 n 位 0 - 9 的 全排列,通过递归生成数字的 String 列表
    int[] res;
    char[] path;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int count = 0;

    public int[] printNumbers2(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        path = new char[n];
        backtracking(0, n);
        return res;
    }

    public void backtracking(int length, int n) {
        if (length == n) {
            String s = String.valueOf(path);
            int num = Integer.parseInt(s);
            if (num == 0) {
                return;
            }
            res[count++] = num;
            return;
        }

        for (int i = 0; i < loop.length; i++) {
            //此题可以不用回溯
            path[length] = loop[i];
            backtracking(length + 1, n);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().printNumbers2(2)));
    }
}
