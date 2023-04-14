package 视频拼接;

public class Solution {
    //从覆盖范围的角度出发，类似于跳跃游戏
    public int videoStitching(int[][] clips, int time) {
        int[] maxn = new int[time];
        //更新以clip[0]为起点的最大覆盖范围，在覆盖范围内的一定可以覆盖，而不用管是怎么覆盖的
        for (int[] clip : clips) {
            if (clip[0] < time) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }

        int curDistance = 0;
        int res = 0;
        int nextDistance = 0;
        for (int i = 0; i < time; i++) {
            nextDistance = Math.max(nextDistance, maxn[i]);
            //到达下一步最远距离，表明不能达到终点
            if (i == nextDistance) {
                return -1;
            }
            //到达当前可跳最大距离，无论如何都需要增加视频序列了
            if (i == curDistance) {
                res++;
                curDistance = nextDistance;
            }
        }
        return res;
    }
}
