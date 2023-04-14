package 子集问题含重复元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>(); //只用添加
    List<Integer> path = new LinkedList<>(); //增和删
    boolean[] used;

    //排序+去重
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums); //排序
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return result;

    }

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex > nums.length) {
            return;
        }

        //去重
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
