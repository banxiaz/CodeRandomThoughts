package of03数组中重复的数字;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //方法1：排序+遍历
    public int duplicate1(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }

        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                return nums[i];
            } else {
                pre = nums[i];
            }
        }
        return -1;
    }

    //使用哈希表快速查找
    public int duplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    //如果数组中每个数字刚好出现一次，那么当数组排好序后i会出现在下标i的位置
    //那么我们依次就将 [数字] 放在 [下标为数字] 的位置，如果在遍历过程中找到nums[i] == nums[nums[i]]，那么重复元素就是nums[i]
    public int duplicate3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    //长度为 n+1 的数组里所有的数字都在1 -- n的范围里，所以数组中至少有一个数字是重复的，请找出数组中任意一个重复的数字
    public int getDuplication(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //统计[1--mid]在数组中出现的次数
            int count = countRange(nums, nums.length, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else break;
            }
            //在左半区继续找
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] nums, int length, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] nums2 = {3, 4, 2, 0, 0, 1};
        int[] nums3 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(new Solution().duplicate3(nums));
        System.out.println(new Solution().getDuplication(nums3));
    }
}
