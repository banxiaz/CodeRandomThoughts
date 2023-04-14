package 跳跃游戏1_;

public class Solution {
    //不用拘泥于每次究竟跳跳几步，而是看覆盖范围，覆盖范围内一定是可以跳过来的，不用管是怎么跳的。
    public boolean canJump(int[] nums) {
        int cover = 0; //当前能到达的最远处的下标,为0
        if (nums.length == 1) { // 只有一个元素，就是能达到
            return true;
        }
        for (int i = 0; i <= cover; i++) { // 注意这里是小于等于cover，而cover是不断更新的
            cover = Math.max(cover, i + nums[i]); //在每一步中取能够到达的最远范围
            if (cover >= nums.length - 1) {
                return true;
            }

        }
        return false;
    }
}
