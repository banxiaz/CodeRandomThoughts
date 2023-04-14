package 组合问题相加之和为n的任意个数;

import java.util.ArrayList;
import java.util.List;

//无重复元素，但是元素可以重复使用
public class Solution {
    List<List<Integer>> result; // 存放符合条件结果的集合
    List<Integer> path; // 用来存放符合条件结果

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(candidates, target, 0, 0);
        return result;

    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        //结束条件
        if (sum > target) return;
        //搜集结果
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i); //不用i+1了，表示可以重复选取
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }
}
