package 组合问题相加之和为n的任意个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//先排序，再剪枝优化
public class Solution2 {
    List<List<Integer>> result; // 存放符合条件结果的集合
    List<Integer> path; // 用来存放符合条件结果

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates); //先排序
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        //搜集结果
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        //对总集合排序之后，如果下一层的sum（就是本层的 sum + candidates[i]）已经大于target，就可以结束本轮for循环的遍历
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i); //不用i+1了，表示可以重复选取
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
