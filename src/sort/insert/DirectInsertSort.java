package sort.insert;

import java.util.Arrays;

/**
 * @description: 直接插入排序
 * 直接插入排序的时间复杂度是O(N2)。
 * <p>
 * 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢? N-1！因此，直接插入排序的时间复杂度是O(N2)
 * @Author: wangchao
 * @Date: 2021/8/26
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        int[] a = {89, 45, 54, 29, 90, 34, 68};
        System.out.println("before sort:" + Arrays.toString(a));
        directInsertSort(a);
        System.out.println("after  sort:" + Arrays.toString(a));
    }

    /**
     * 直接插入排序
     * <p>
     * 参数说明:
     * 89 45 54 29 90 34 68
     * 45 89 54 29 90 34 68
     * 45 54 89 29 90 34 68
     * 29 45 54 89 90 34 68
     * 29 45 54 89 90 34 68
     * 29 34 45 54 89 90 68
     * 29 34 45 54 68 89 90
     * array -- 待排序的数组
     */
    public static void directInsertSort(int[] array) {
        // 数量小于2直接返回
        if (array == null || array.length < 2) {
            return;
        }

        // 从第二个开始
        for (int i = 1; i < array.length; i++) {
            // 当前将要插入的数
            int cur = array[i];
            boolean flag = false;

            for (int j = i - 1; j > -1; j--) {

                // 如果插入的数小于前面一个数，则将前面的数后移
                if (cur < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    // 如果插入的数大于前面一个数，则将其赋值后j+1，并退出当前循环
                    array[j + 1] = cur;
                    flag = true;
                    break;
                }
            }

            // 如果将要插入的数 前面没有比它大的数，则将其放到第一位
            if (!flag) {
                array[0] = cur;
            }
        }
    }
}
