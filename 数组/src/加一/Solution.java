package 加一;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                i--;
            } else {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{0};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
    }
}
