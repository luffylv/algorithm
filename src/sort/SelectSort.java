package sort;


/**
 * @Description 选择排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class SelectSort {

    /**
     * 选择排序的基本思想是在每一轮选择最小（或最大）的元素，然后将其放置在数组的起始位置，这个过程重复进行，
     * 每次迭代都从剩余未排序的元素中选择最小（或最大）的元素，放到已排序序列的末尾
     *
     * 算法步骤：
     * 1.从未排序的序列中找到最小（或最大）元素。
     * 2.将找到的最小（或最大）元素和未排序序列的第一个元素交换。
     * 3.重复以上步骤，每次迭代都减少未排序序列的长度。
     *
     * 时间复杂度：
     * 最好、最坏和平均情况下都是 \(O(n^2)\)。
     *
     *
     * 空间复杂度：
     * (O(1))，因为它是一个原地排序算法。
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // i ～ N-1上找最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            selectionSort(arr1);
            CompareData.comparator(arr2);
            if (!CompareData.isEqual(arr1, arr2)) {
                succeed = false;
                CompareData.printArray(arr1);
                CompareData.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        selectionSort(arr);
        CompareData.printArray(arr);
    }

}
