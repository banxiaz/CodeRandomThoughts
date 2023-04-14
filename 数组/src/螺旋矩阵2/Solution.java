package 螺旋矩阵2;

import java.util.Arrays;

public class Solution {
    //一定是矩阵
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, top = 0, right = columns - 1, bottom = rows - 1;
        int value = 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = value++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = value++;
            }
            for (int column = right - 1; column >= left + 1; column--) {
                matrix[bottom][column] = value++;
            }
            for (int row = bottom; row >= top + 1; row--) {
                matrix[row][left] = value++;
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(4)));
    }
}
