

package sort;

import java.util.Arrays;

/**
 * @Description 选择排序
 *
 * @Program algorithm
 * @Date 2024-06-03
 **/
public class SelectSort {


    public static void main(String[] args) {
        int[] a = new int[]{5, 16, 9, 1, 5, 32, 4, 87, 31, 5, 2};
        process(a);
        System.out.println(Arrays.toString(a));
    }


    private static void process(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }
    }


}
