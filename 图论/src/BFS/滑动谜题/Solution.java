package BFS.滑动谜题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    // 类似于层次遍历，首先找到'0'的位置，然后每次将0与相邻的元素交换位置，步数加1，直到找到目标为止，要避免重复交换。
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();
        // 记录⼀维字符串在二维中的的相邻索引
        int[][] neighbor = new int[][]{{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};

        /******* BFS 算法框架开始 *******/
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                while (cur.charAt(idx) != '0') {
                    idx++;
                }
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    String newBoard = swap(cur.toCharArray(), adj, idx);
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
