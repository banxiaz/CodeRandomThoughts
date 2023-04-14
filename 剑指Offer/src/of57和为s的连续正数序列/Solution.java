package of57和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] ans = new int[right - left + 1];
                for (int k = left; k <= right; k++) {
                    ans[k - left] = k;
                }
                res.add(ans);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(9)));
    }
}
