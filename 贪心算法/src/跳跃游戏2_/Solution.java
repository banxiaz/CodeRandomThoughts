package 跳跃游戏2_;

public class Solution {
    //要从覆盖范围出发，不管怎么跳，覆盖范围内一定是可以跳到的
    //以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，得到的就是最小步数！
    //这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curDistance = 0;    // 当前覆盖最远距离下标，初始为0
        int ans = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖最远距离下标
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, nums[i] + i); // 在每一步移动的过程中，不断更新下一步覆盖最远距离下标
            if (i == curDistance) {                             // 遇到当前覆盖最远距离下标
                if (curDistance != nums.length - 1) {           // 如果当前覆盖最远距离下标不是终点
                    ans++;                                      // 需要走下一步
                    curDistance = nextDistance;                 // 更新当前覆盖最远距离下标（相当于加油了）
                    if (nextDistance >= nums.length - 1) {      // 下一步的覆盖范围已经可以达到终点，结束循环
                        break;
                    }
                } else {
                    break;                                      // 当前覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
                }
            }
        }
        return ans;
    }
}
