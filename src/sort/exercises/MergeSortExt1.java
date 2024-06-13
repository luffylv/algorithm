package sort.exercises;

import sort.CompareData;

/**
 * @Description 归并排序的扩展——小和问题
 *              在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和，求一个数组的小和。
 *              例子：[1,3,4,2,5,6] 1左边比1小的数，没有；3左边比3小的数，1；4左边比4小的数，1、3；2左边比2小的数，1；
 *              5左边比5小的数，1、3、4、2；所以小和为1+1+3+1+1+3+4+2=16
 *
 * @Program algorithm
 * @Date 2024-06-13
 **/
public class MergeSortExt1 {


    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和返回
    // 所有merge时，产生的小和，累加
    // 左 排序   merge
    // 右 排序  merge
    // merge
    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int smallSum = 0;
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                smallSum = smallSum + arr[p1] * (R - p2 + 1);
                temp[index++] = arr[p1++];
            } else if (arr[p1] == arr[p2]) {
                // 求使用归并排序解小和问题排好序的数组不能保证稳定性
                temp[index++] = arr[p2++];
            } else {
                temp[index++] = arr[p2++];
            }
        }

        while (p1 <= M) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[index++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
//        System.out.println("L:" + L + " M:" + M + " R:" + R + " smallSum:" + smallSum);

        return smallSum;
    }

    public static int getSmallSum2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int smallSum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j]) {
                    smallSum += arr[j];
                }
            }
        }
        return smallSum;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            int smallSum1 = getSmallSum(arr1);
            int smallSum2 = getSmallSum2(arr2);
            if (smallSum1 != smallSum2) {
                succeed = false;
                CompareData.printArray(arr2);
                CompareData.printArray(arr1);
                System.out.println(smallSum1);
                System.out.println(smallSum2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        int smallSum = getSmallSum(arr);
        System.out.println(smallSum);
        CompareData.printArray(arr);
    }
}
