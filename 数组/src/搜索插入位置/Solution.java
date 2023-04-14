package 搜索插入位置;

//35
public class Solution {
    /*二分查找找不到元素时的规律 x-1  x  x+1
    - 最后一次进入循环一定是 left==right
    - 结束循环之后一定是 right+1=left
    - left指向一定大于target
    - right指向一定小于target
    * */
    public int searchInsert(int[] nums, int target) {
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
        //left指向的是第一个大于target的位置
        return left;
    }
}
