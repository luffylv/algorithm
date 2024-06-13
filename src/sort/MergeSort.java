package sort;


/**
 * @Description 归并排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class MergeSort {

    /**
     * 归并排序是一种高效的排序算法，基于分治法的思想。它将一个数组分成两半，分别对这两半进行排序，然后将排序
     * 好的两半合并在一起。这种方法在最坏情况下、平均情况和最好情况下的时间复杂度都是O(nlogn)，其中n是数组的长度。
     * 归并排序是稳定的排序算法，意味着相同的元素在排序前后会保持原来的顺序。
     *
     * 归并排序的步骤
     * 1.分解：将当前区间一分为二，递归地对两个子区间进行归并排序。
     * 2.合并：将两个有序的子区间合并成一个有序区间。
     *
     * 特点和应用
     * 稳定性：归并排序是稳定的排序算法。
     * 空间复杂度：由于需要额外的存储空间来合并两个子数组，归并排序的空间复杂度为O(n)。
     * 适用场景：归并排序非常适合于数据量大的情况，尤其是链表排序，因为它的空间复杂度可以通过链表的重新链接来优化到O(1)。
     *
     * 整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
     * 让其整体有序的过程里用了外排序方法
     * 利用master公式来求解时间复杂度
     * 归并排序的时间复杂度O(nlogn)，额外空间复杂度O(n)
     */
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
