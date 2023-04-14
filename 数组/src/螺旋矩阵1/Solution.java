package 螺旋矩阵1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //不一定是矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, top = 0, right = columns - 1, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= left + 1; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row >= top + 1; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return order;
    }
}
