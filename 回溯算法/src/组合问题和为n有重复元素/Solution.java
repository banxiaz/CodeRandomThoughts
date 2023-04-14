package 组合问题和为n有重复元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//有重复元素，但每个元素在每个组合只能使用一次
//难点在于：集合（数组candidates）有重复元素，但还不能有重复的组合
public class Solution {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates); // 首先把给candidates排序，让其相同的元素都挨在一起。
        backtracking(candidates, target, 0, 0, new boolean[candidates.length]);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        /*
        要去重的是“同一树层上的使用过”
        如果8 并且 used[i - 1] == false
        就说明：前一个树枝，使用了candidates[i - 1]
        也就是说同一树层使用过candidates[i - 1]

        在candidates[i] == candidates[i - 1]相同的情况下：
        - used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
        - used[i - 1] == false，说明同一树层candidates[i - 1]使用过
        * */

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, sum, i + 1, used); //不可重复选取
            used[i] = false;
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{1, 1, 1}, 2));
    }
}
