package 错误的集合;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        //集合包含从1到n的整数，但是有一个数重复，一个数缺失，总长度依然为 n
        //考虑将nums中的数作为索引在nums中再进行操作
        //从第一个数开始遍历nums，将nums[i]作为索引，将此索引中的数变为负数
        //在遍历到某一个数时，已经为负数了，表示nums[i]为重复元素
        //遍历完之后，nums中有一个数为正数，这个正数所在的索引就是缺失的数，因为没有索引能够访问到它
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        return new int[]{dup, missing};
    }
}
