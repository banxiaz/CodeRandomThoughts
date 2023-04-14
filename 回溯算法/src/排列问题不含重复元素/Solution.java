package 排列问题不含重复元素;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //path里已经收录的元素，直接跳过，防止这个元素被再取
            if (used[i]) {
                continue;
            }
            //同一个数组，但是每次都是从下标0开始，所以需要一个used数组记录是否被使用过
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used); //不需要startIndex了，每次都是从0开始的
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}
