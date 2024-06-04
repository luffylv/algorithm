package sort;


/**
 * @Description 冒泡排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class BubbleSort {


    /**
     * 冒泡排序的基本思想是通过遍历要排序的列表，比较每对相邻项，然后交换顺序错误的项，每一轮遍历都会将未排序部分的最大
     * （或最小）元素“冒泡”到序列的末尾。
     *
     * 算法步骤：
     * 1.比较相邻的元素。如果第一个比第二个大（小），就交换他们。
     * 2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大（或最小）的数。
     * 针对所有的元素重复以上的步骤，除了最后已经排序的元素。
     * 重复步骤1～3，直到排序完成。
     *
     * 时间复杂度：
     * 最好情况O(n):如果数组已经是排序好的。
     * 最坏和平均情况(O(n^2))。
     *
     * 空间复杂度：
     * (O(1))，因为它是一个原地排序算法。
     *
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            bubbleSort(arr1);
            CompareData.comparator(arr2);
            if (!CompareData.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        bubbleSort(arr);
        CompareData.printArray(arr);
    }


}
