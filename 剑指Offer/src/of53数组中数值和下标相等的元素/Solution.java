package of53数组中数值和下标相等的元素;

public class Solution {
    public int getValueEqIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 3, 5};
        System.out.println(new Solution().getValueEqIndex(nums));
    }
}
