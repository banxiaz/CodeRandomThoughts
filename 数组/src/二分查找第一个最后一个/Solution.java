package 二分查找第一个最后一个;

import java.util.Arrays;

//34
public class Solution {
    //寻找左边界(不包含target)
    public int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; //记录一下找不到的情况
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) { //只要大于或者等于，那么缩小右边界
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    //寻找右边界(不包含target)
    public int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; //记录一下找不到的情况
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        //target 在数组范围的右边或者左边
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        //target 在数组范围中，且数组中存在target
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        //target 在数组范围中，且数组中不存在target
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, 0)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 2)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 3)));
    }
}
