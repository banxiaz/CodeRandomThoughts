package of39数组中出现次数超过一半的数字;

public class Solution {
    //摩尔投票法
    //- 不是众数的数相互抵消，最后留下来的一定是众数
    //- 考虑最坏的情况，每一次不同的数都与众数抵消，留下来的也一定是众数
    public int majorityElement_(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                times++;
            } else if (times == 0) {
                result = nums[i];
                times = 1;
            } else {
                times--;
            }
        }
        return result;
    }

    //基于分治法
    public int majorityElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) / 2;
        int index = partition(nums, start, end);

        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }

        return nums[mid];
    }

    public int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int key = nums[left];
        //保证至少有2个数字要排序
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] <= key) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        return i; //i==j
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 1, 2, 1, 1};
        System.out.println(new Solution().majorityElement(nums));
    }
}
