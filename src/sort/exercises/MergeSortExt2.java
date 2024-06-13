package sort.exercises;

import sort.CompareData;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 归并排序的扩展——逆序对问题
 *              在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对
 *              假设有一个数组 [4, 3, 2, 1]：
 *              逆序对包括：(4, 3), (4, 2), (4, 1), (3, 2), (3, 1), (2, 1)。
 *              这个数组的逆序对总数为 6。
 *
 * @Program algorithm
 * @Date 2024-06-13
 **/
public class MergeSortExt2 {


    public static Map<String, Integer> getReverseOrderPairs(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        if (arr == null || arr.length < 2) {
            return new HashMap<>();
        }

        process(arr, 0, arr.length - 1, map);
        return map;
    }

    private static void process(int[] arr, int L, int R, Map<String, Integer> map) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M, map);
        process(arr, M + 1, R, map);
        merge(arr, L, R, M, map);
    }

    private static void merge(int[] arr, int L, int R, int M, Map<String, Integer> map) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] > arr[p2]) {
                for (int j = p1; j <= M; j++) {
                    String key = arr[j] + "," + arr[p2];
                    int value = map.containsKey(key) ? map.get(key) + 1 : 1;
                    map.put(key, value);
//                    System.out.println("<" + arr[j] + "," + arr[p2] + ">");
                }
                temp[i++] = arr[p2++];
            } else {
                temp[i++] = arr[p1++];
            }
        }

        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }

    public static Map<String, Integer> getReverseOrderPairs2(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        if (arr == null || arr.length < 2) {
            return map;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    String key = arr[i] + "," + arr[j];
                    int value = map.containsKey(key) ? map.get(key) + 1 : 1;
                    map.put(key, value);
//                    System.out.println("<" + arr[i] + "," + arr[j] + ">");
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CompareData.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CompareData.copyArray(arr1);
            Map<String, Integer> map1 = getReverseOrderPairs(arr1);
            Map<String, Integer> map2 = getReverseOrderPairs2(arr2);
            if (!map1.equals(map2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = CompareData.generateRandomArray(maxSize, maxValue);
        CompareData.printArray(arr);
        Map<String, Integer> map = getReverseOrderPairs(arr);
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            for (int i = 0; i < value; i++) {
                System.out.println(key);
            }
        }
    }


//    public static void main(String[] args) {
//        int[] arr1 = new int[]{1, 3, 4, 2, 5, 6, 2};
//        int[] arr2 = new int[]{1, 3, 4, 2, 5, 6, 2};
//        Map<String, Integer> map1 = getReverseOrderPairs(arr1);
//        for (String key:map1.keySet()){
//            Integer value = map1.get(key);
//            for (int i = 0; i < value; i++) {
//                System.out.println(key);
//            }
//        }
//        System.out.println("******************************");
//        getReverseOrderPairs2(arr2);
//        for (String key:map1.keySet()){
//            Integer value = map1.get(key);
//            for (int i = 0; i < value; i++) {
//                System.out.println(key);
//            }
//        }
//    }

}
