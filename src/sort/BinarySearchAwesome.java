package sort;

/**
 * @Description 二分查找，局部最小值问题
 *
 * @Program algorithm
 * @Date 2024-06-06
 **/
public class BinarySearchAwesome {

    /**
     * 在一个无序数组中，任何两个相邻的数一定不相等
     * 局部最小的定义为：若0位置上的值小于1位置上的值，则0位置是局部最小的位置
     *                若N-1位置上的值小于N-2位置上的值，则N-1位置是局部最小的位置
     *                若i位置上的值小于i-1和i+1位置上的值，则i位置是局部最小的位置
     * 求一个局部最小的位置就可以
     */
    public static int binarySearchAwesome(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int L = 1;
        int R = arr.length - 2;

        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
//            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
//                return mid;
//            } else if (arr[mid - 1] < arr[mid]) {
//                R = mid - 1;
//            } else if (arr[mid] > arr[mid + 1]) {
//                L = mid + 1;
//            }
        }
        return L;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 3, 5, 7, 11, 6, 11, 55, 77, 99};
        int location = binarySearchAwesome(arr);
        System.out.println(location);
    }
}
