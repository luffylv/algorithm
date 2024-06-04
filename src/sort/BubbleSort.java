

package sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class BubbleSort {

    public static void main(String[] args) {
//        int[] a = new int[]{5, 16, 9, 1, 5, 32, 4, 87, 31, 5, 2};
        int[] a = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        process(a);
        System.out.println(Arrays.toString(a));
    }


    private static void process(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
}
