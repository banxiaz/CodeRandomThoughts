package of29顺时针打印矩阵;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, index = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];

        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i]; // left to right.
            }
            if (++top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right]; // top to bottom.
            }
            if (left > --right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i]; // right to left.
            }
            if (top > --bottom) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left]; // bottom to top.
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
