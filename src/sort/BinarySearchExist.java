package sort;

/**
 * @Description 二分查找，在一个有序数组中，找某个数是否存在
 *
 * @Program algorithm
 * @Date 2024-06-06
 **/
public class BinarySearchExist {

    public static boolean binarySearchExist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        while (L < R) {
            // mid =(L+R) / 2;
            // mid = L + (R- L) / 2;
            // N / 2 N >> 1
            int mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;

//        if (l == r) {
//            return arr[l] == num;
//        }
//        if (r - l == 1) {
//            return num == arr[l] || num == arr[r];
//        }
//
//        int mid = l + (r - l + 1) / 2;
//        if (num == arr[mid]) {
//            return true;
//        }
//        l = arr[mid] > num ? l : mid;
//        r = arr[mid] > num ? mid : r;
//        return binarySearchExist(arr, l, r, num);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 33, 55, 77, 99};
        boolean res = binarySearchExist(arr, 77);
        System.out.println(res);
    }

}
