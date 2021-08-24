package sort.exchange;

import java.util.Arrays;

/**
 * @description: 交换排序系列之冒泡排序
 * 时间复杂度 O(N^2)
 * 冒泡排序的时间复杂度是O(N2)。 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢? N-1次！因此，冒泡排序的时间复杂度是O(N2)。
 * @Author: wangchao
 * @Date: 2021/8/24
 */
public class BubbleSort {
    public static void main(String[] args) {
        int count = 1;
        int[] a = {4, 1, 2, 3, 4, 1, 3};
        for (int i = 0; i < a.length; i++) {
            int flag = 0;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int swap = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = swap;

                    // 如果发生了交换则标记
                    flag = 1;
                }
            }
            if (flag == 0) {
                // 如果没有发生交换 则退出
                break;
            }
            System.out.println("第" + count++ + "趟:" + Arrays.toString(a));
        }
        System.out.println("最终结果：" + Arrays.toString(a));
    }
}
