package Hanoi;

public class Solution {
    //这个递归函数作用：把放在第一参数位的东西移动到第三参数位，第二参数位是缓冲区
    //或者说，将第一参数位置的塔移动到第三位置，参数名称并不重要！！！
    //千万不能被参数名称迷惑了
    public static void hanoi(int n, char x, char y, char z) {
        if (n == 1) {
            System.out.println(x + "-->" + z); //直接移动
        } else {
            hanoi(n - 1, x, z, y);//将前n-1层的塔，从第一位置(起点x)移动到第三位置(缓冲区y)
            System.out.println(x + "-->" + z);//
            hanoi(n - 1, y, x, z);//将前n-1层的塔，从第一位置(缓冲区y)移动到第三位置(终点z)
        }
    }

    public static void main(String[] args) {
        Solution.hanoi(3, 'A', 'B', 'C');
    }
}
