package 黑名单中的随机数;

import java.util.*;

public class Solution {
    Map<Integer, Integer> map;
    Random random;
    int preLen;

    // 将n分成长度为 n-b 和 b 的两部分，前半部分中有i个元素在黑名单中，后半部分就有i个元素不在黑名单中
    // 将前半部分的黑名单与后半部分的白名单一一映射，这样就只用从前半部分取
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        preLen = n - blacklist.length;

        Set<Integer> lastNotInBlack = new HashSet<>();
        for (int i = preLen; i < n; i++) {
            lastNotInBlack.add(i);
        }
        for (int item : blacklist) {
            lastNotInBlack.remove(item);
        }
        Iterator<Integer> li = lastNotInBlack.iterator();
        for (int b : blacklist) {
            if (b < preLen) {
                map.put(b, li.next());
            }
        }
    }

    public int pick() {
        int index = random.nextInt(preLen);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(6, new int[]{0, 2, 3});
        System.out.println(solution.pick());
    }
}
