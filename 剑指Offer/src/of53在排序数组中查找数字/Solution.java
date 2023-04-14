package of53在排序数组中查找数字;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int left = getLeftBorder(nums, target);
        int right = getRightBorder(nums, target);
        if (left == -2 || right == -2) {
            return 0;
        } else {
            return right - left - 1;
        }
    }

    public int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                res = right;
            } else {
                left = mid + 1;
            }
        }
        //左边界的左边
        return res;
    }

    public int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                res = left;
            } else {
                right = mid - 1;
            }
        }
        //右边界的右边
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10, 8};
        System.out.println(new Solution().search(nums, 8));
    }
}
