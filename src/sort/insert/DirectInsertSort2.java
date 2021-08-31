package sort.insert;

import java.util.Arrays;

/**
 * @description: 直接插入排序
 * 设置哨兵位，记录上一次插入的值和位置，若当前插入的值小于前面一次插入的值，则将上次插入位置之后的值全部后移，从上个插入位置作为比较比较的起点
 * 反之，仍然从有序数组的最后一位进行比较
 * @Author: wangchao
 * @Date: 2021/8/26
 */
public class DirectInsertSort2 {
    public static void main(String[] args) {
//        int[] a = {89, 45, 54, 29, 90, 34, 68};
//        int[] a = {10, 9, 8, 7, 6, 5, 4};
        int[] a = {2,1,3};
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

        // 上一次插入的值
        int lastNum = array[0];
        // 上一次插入的位置
        int lastIndex = 0;

        // 从第二个开始
        for (int i = 1; i < array.length; i++) {
            // 当前将要插入的数
            int cur = array[i];
            boolean flag = false;

            int start = i - 1;
            // 如果 当前要插入的数小于最近一次插入的数，则将最近一次插入的数和其之后的数全部后移
            if (cur < lastNum) {
                start = lastIndex;
                for (int j = i - 1; j > start - 1; j--) {
                    array[j + 1] = array[j];
                }
            }

            // 如果 当前要插入的数小于最近一次插入的数，则start=lastIndex
            for (int j = start; j > -1; j--) {
                // 如果插入的数小于前面一个数，则将前面的数后移
                if (cur < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    // 如果插入的数大于前面一个数，则将其赋值后j+1，并退出当前循环
                    array[j + 1] = cur;
                    // 记录当前插入的值和位置
                    lastNum = cur;
                    lastIndex = j + 1;
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
