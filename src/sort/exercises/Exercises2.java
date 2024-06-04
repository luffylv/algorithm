package sort.exercises;


/**
 * @Description 在一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数。
 *
 * @Program algorithm
 * @Date 2024-06-04
 **/
public class Exercises2 {

    public static void main(String[] args) {
        // 3和6只出现奇数次，均为1次
        int[] arr = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 9};

        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        // 0110010000
        // 0000010000
        int rightOne = eor & (~eor + 1);// 提取出最右的1
        int onlyOne = 0;
        for (int cur : arr) {
            if ((rightOne & cur) == 1) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + ", " + (eor ^ onlyOne));
    }

}
