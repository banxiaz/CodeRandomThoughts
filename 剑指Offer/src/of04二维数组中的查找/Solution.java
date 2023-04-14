package of04二维数组中的查找;


public class Solution {
    //首先选取数组中右上角的数字，从右上角看相当于 [一棵二叉搜索树]
    //如果等于目标数字，则查找结束，相当于根节点
    //如果大于目标数字，则剔除这个数字所在的列，相当于找左子树
    //如果小于目标数字，则剔除这个数字所在的行，相当于找右子树
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(new Solution().findNumberIn2DArray(nums, 7));
        int[][] n2 = {{}, {}, {}};
        System.out.println(n2.length);
        System.out.println(n2[0].length);
    }
}
