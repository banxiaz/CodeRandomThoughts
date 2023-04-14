package 分发饼干;

import java.util.Arrays;

public class Solution {
    //小饼干--大胃口
    //g <= s
    //饼干s  -[1 3 5 9]
    //小孩g   [1 2 7 10]-

    //思路1：小胃口既可以被小饼干满足，又可以被大饼干满足，那么就优先被小饼干满足，满足条件的最小饼干是哪一个呢？
    // 所以需要从小到大遍历饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) { //饼干
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }

    // 思路2：大饼干既可以分给大胃口，又可以分给小胃口，那么就优先分给大胃口，满足条件最大胃口是哪一个呢？
    // 所以需要从大到小遍历胃口
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1; // 饼干数组的下标
        for (int i = g.length - 1; i >= 0; i--) { //胃口
            //防止饼干比小孩多，小孩分配完了，饼干有剩余
            if (index >= 0 && g[i] <= s[index]) {
                index--;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 3, 5, 9}; //饼干
        int[] s = new int[]{1, 2, 7, 10}; //胃口
        System.out.println(new Solution().findContentChildren(g, s));
        System.out.println(new Solution().findContentChildren2(g, s));
    }
}
