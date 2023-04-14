package 二分查找找最后;

public class BinarySearch {
    /**
     * 找最后，缩左界
     * 终循环，左右等（等有两个意思 1.left=right 2.arr[left]=arr[right]=target）
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 3, 4, 4,};
        int index = search(arr, 3);
        System.out.println(index);
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //right指向最后一个target
        //left指向第一个大于target
        //right+1=left
        return right;
    }
}
