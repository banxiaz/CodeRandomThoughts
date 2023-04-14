package 组合问题相加之和为n的k个数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(n, k, 1, 0);
        return result;
    }

    public void backtracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) { //剪枝
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) { //剪枝 for (int i = startIndex; i <= 9; i++)
            sum += i;
            path.add(i);
            backtracking(targetSum, k, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
