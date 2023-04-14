package 子集问题不含重复元素;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        //「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        result.add(new ArrayList<>(path));
        //终止条件可不加，因为 i < nums.length 是一定的
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
