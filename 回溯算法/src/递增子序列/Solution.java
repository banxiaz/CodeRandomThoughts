package 递增子序列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
            // 注意这里不要加return，因为要取树上的所有节点
        }

        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            //path不为空时最后一个数大于了将添加的数 || 要添加的数已经被使用过了
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1; // 记录【这个元素】在本层用过了，本层后面不能再用了，不用回溯！！！
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 7, 6, 7}));
    }
}
