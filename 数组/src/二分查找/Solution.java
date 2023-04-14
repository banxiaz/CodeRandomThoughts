package 二分查找;

//704
public class Solution {
    //左闭右闭[left, right]
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //左闭右开[left, right)
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //递归二分查找1
    public int search3(int[] nums, int target, int left, int right) {
        //终止条件
        if (left > right) {
            return -1;
        } else {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return search3(nums, target, left, mid - 1);
            } else {
                return search3(nums, target, mid + 1, right);
            }
        }
    }

    //递归二分查找2
    public int search4(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return search4(nums, target, left, mid - 1);
            } else {
                return search4(nums, target, mid + 1, right);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        System.out.println(new Solution().search(nums, target));
        System.out.println(new Solution().search2(nums, target));
        System.out.println(new Solution().search3(nums, target, 0, nums.length - 1));
        System.out.println(new Solution().search4(nums, target, 0, nums.length - 1));
    }

}
