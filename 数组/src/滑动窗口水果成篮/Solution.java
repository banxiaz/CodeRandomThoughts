package 滑动窗口水果成篮;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //求最多包含两种元素的最长连续子序列
    public int totalFruit(int[] fruits) {
        // 我们发现形成窗口大小其实是固定的(两个篮子==果子种类)
        // 键为果子类型，值为果子数量
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            // 窗口果子种类超过两种果子了，丢掉一个种类的果子，始终保持窗口内部只有最多两种类型的水果
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]); //如果当前水果数量为0，则移除这个水果类型
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
