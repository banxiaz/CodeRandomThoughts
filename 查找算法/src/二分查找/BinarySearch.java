package 二分查找;

public class BinarySearch {
    /*
     * 二分查找，无重复元素，找不到时一定存在的规律： x-1   x   x+1
     * - 1.left指向一定大于target
     * - 2.right指向一定小于target
     * - 3.且 right+1=left
     * 为什么？
     * 找不到时，最后一次进while循环一定满足 left == right
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int a : arr) {
            System.out.println(search(arr, a));
        }
        System.out.println(search(arr, 100));
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
