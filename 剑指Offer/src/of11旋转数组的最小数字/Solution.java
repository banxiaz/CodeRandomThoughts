package of11旋转数组的最小数字;

public class Solution {
    //要找的值<=最右边的值
    //1. 如果mid>right，那么mid一定大于要找的值，所以要在右半区间找，即left=mid+1
    //2. 如果mid<right，有两种情况，综合起来就是right=mid
    //2.1 mid就是要找的值
    //2.2 mid比要找的值大
    //3. 如果mid=right，有两种情况，此时不能判断收缩哪一个区间，那么取并集就是right-1，相当于将区间向左收缩
    //3.1 要找的值在mid的右边
    //3.2 要找的值在mid的左边
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        int[] nums1 = {1, 0, 1, 1, 1};
        int[] nums2 = {1, 1, 1, 2, 3, 1};
        System.out.println(new Solution().minArray(nums2));
    }
}
