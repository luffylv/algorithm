package sort;


/**
 * @Description 归并排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class MergeSort {

    // 递归方法实现
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，变成有序的
    // L...R    N    T(N) = 2*T(N/2) + O(N)  ->
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, R, M);
    }

    private static void merge(int[] arr, int L, int R, int M) {
        // 使用外排序方法
        int[] a = new int[R - L + 1];
        int ll = L;
        int rl = M + 1;
        int i = 0;
//        for (; i < R - L + 1 && ll <= M && rl <= R; i++) {
//            a[i] = arr[ll] <= arr[rl] ? arr[ll++] : arr[rl++];
//        }
        while (ll <= M && rl <= R) {
            a[i++] = arr[ll] <= arr[rl] ? arr[ll++] : arr[rl++];
        }
        // 要么ll越界了，要么rl越界了
        while (ll <= M) {
            a[i++] = arr[ll++];
        }

        while (rl <= R) {
            a[i++] = arr[rl++];
        }

        for (i = 0; i < a.length; i++) {
            arr[L + i] = a[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            mergeSort(arr1);
            CompareData.comparator(arr2);
            if (!CompareData.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        mergeSort(arr);
        CompareData.printArray(arr);
    }

    // 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;// 当前有序的，左组长度
        while (mergeSize < N) { // log N
            int L = 0;
            // 0....
            while (L < N) {
                // L...M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                //  L...M   M+1...R(mergeSize)
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
