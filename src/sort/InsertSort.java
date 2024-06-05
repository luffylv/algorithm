package sort;

/**
 * @Description 插入排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class InsertSort {


    /**
     * 通过构建有序序列，对于未排序得数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * 算法步骤：
     * 1.从第一个元素开始，该元素可以认为已经被排序。
     * 2.取出下一个元素，在已经排序得元素序列中从后向前扫描。
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置。
     * 4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置，或没有下一元素为止。
     * 5.将新元素插入到该位置后重复步骤2～5
     *
     * 稳定排序。
     * 最好情况(O(n))（已经排序的数组），最坏和平均情况(O(n^2))。
     * 适合部分已排序的数据，因为它可以提前终止扫描。
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j -1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int tesTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < tesTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            insertionSort(arr1);
            CompareData.comparator(arr2);
            if (!CompareData.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        insertionSort(arr);
        CompareData.printArray(arr);
    }


}
