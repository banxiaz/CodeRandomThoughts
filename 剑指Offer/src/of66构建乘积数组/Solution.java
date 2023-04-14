package of66构建乘积数组;

import java.util.Arrays;

public class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }

        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }

        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    res[i] *= a[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Solution().constructArr2(a)));
    }
}
