package sort.exchange;

import java.util.Arrays;

/**
 * @description: 交换排序之快速排序
 * 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 * @Author: wangchao
 * @Date: 2021/8/24
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {30, 40, 60, 40, 20, 50};
//        int[] a = {30, 40, 50, 60, 70, 80};
        System.out.println("before sort:" + Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("after  sort:" + Arrays.toString(a));
    }

    /**
     * 快速排序
     * <p>
     * 参数说明:
     * a -- 待排序的数组
     * left -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     * right -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        // 标准数
        int x = a[l];
        while (l < r) {
            // 找出右边第一个比 x 小的数
            while (l < r && a[r] >= x) {
                --r;
            }
            if (l < r) {
                a[l] = a[r];
                ++l;
            }

            // 找出左边第一个比 x 大的数
            while (l < r && a[l] < x) {
                ++l;
            }
            if (l < r) {
                a[r] = a[l];
                --r;
            }
        }
        a[l] = x;

        //递归调用左半数组
        quickSort(a, left, l - 1);

        //递归调用右半数组
        quickSort(a, l + 1, right);
    }
}
