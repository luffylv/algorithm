package sort.exercises;


/**
 * @Description 在一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
 *
 * @Program algorithm
 * @Date 2024-06-04
 **/
public class Exercises1 {

    public static void main(String[] args) {
        // 1只出现奇数次，1次
        int[] arr = new int[]{1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }
        System.out.println(num);
    }
}
