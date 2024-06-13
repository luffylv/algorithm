package sort;


/**
 * @Description 归并排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class MergeSortMe {

    private static int[] mergeSort(int[] arr, int l, int r) {

        if (arr == null) {
            return null;
        }
        if (l == r) {
            return new int[]{arr[l]};
        }
        int mid = l + ((r - l) >> 1);
        int[] left = mergeSort(arr, l, mid);
        int[] right = mergeSort(arr, mid + 1, r);
        arr = merge(left, right);

        return arr;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (leftIndex == left.length - 1) {
                arr[i] = right[++rightIndex];
            } else if (rightIndex == right.length - 1) {
                arr[i] = left[++leftIndex];
            } else {
                arr[i] = left[leftIndex + 1] <= right[rightIndex + 1] ? left[++leftIndex] : right[++rightIndex];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int testTime = 40;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            arr1 = mergeSort(arr1, 0, arr1.length - 1);
            CompareData.comparator(arr2);
            if (!CompareData.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        CompareData.printArray(arr);
    }
}
