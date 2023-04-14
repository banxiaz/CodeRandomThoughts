package of12矩阵中的路径;


public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                chars[start] != board[i][j] || visited[i][j]) {
            return false;
        }

        if (start == chars.length - 1) {
            return true;
        }

        visited[i][j] = true;
        //找到一条路径即返回，不能分开写
        boolean ans = backtracking(board, chars, visited, i + 1, j, start + 1)
                || backtracking(board, chars, visited, i - 1, j, start + 1)
                || backtracking(board, chars, visited, i, j + 1, start + 1)
                || backtracking(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false; //回溯
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }
}
