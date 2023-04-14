package 划分字母区间_;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了
    //- 统计每一个字符最后出现的位置
    //- 从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        //在遍历的过程中，不断更新每一个字母的右边界
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            //在没有到达分割点之前，不断更新当前字符的最右边界下标
            right = Math.max(right, edge[chars[i] - 'a']);
            if (i == right) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }
}
