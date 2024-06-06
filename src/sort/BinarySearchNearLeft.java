package sort;

/**
 * @Description 二分查找，在一个有序数组中，找小于等于某个数最左侧的位置
 *
 * @Program algorithm
 * @Date 2024-06-06
 **/
public class BinarySearchNearLeft {

    // 在arr上，找满足>=value的最左位置
    public static int binarySearchNearLeft(int[] sortArr, int num) {
        if (sortArr == null || sortArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortArr.length - 1;
        // 记录最左的对号
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (sortArr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 11, 11, 33, 55, 77, 99};
        int location = binarySearchNearLeft(arr, 11);
        System.out.println(location);
    }
}
