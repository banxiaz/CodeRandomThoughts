package 移除元素;

//27
public class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            //快指针遍历每一个元素
            //慢指针指向与val不等的元素应该放的位置，如果与val相等的话，慢指针不用动
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
