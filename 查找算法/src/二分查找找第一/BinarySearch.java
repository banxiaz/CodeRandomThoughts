package 二分查找找第一;

public class BinarySearch {
    /**
     * 找第一，缩右界
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
            if (arr[mid] >= target) { //只要大于或者等于，那么缩小右边界
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //right指向最后一个小于target
        //left指向第一个target
        //right+1=left
        return left;
    }
}
