package 加油站;

public class Solution {
    //rest[i]=gas[i]-cost[i]
    //i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，起始位置从i+1算起，再从0计算curSum
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i]; //判断总油量是否大于总消耗量
            if (curSum < 0) {   // 当前累加rest[i] 的和 curSum一旦小于0
                start = i + 1;  // 起始位置更新为i+1
                curSum = 0;     // curSum从0开始
            }
        }
        if (totalSum < 0) {     // 说明怎么走都不可能跑一圈了
            return -1;
        }
        return start;
    }
}
