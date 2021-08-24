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
        int[] a = {30, 40, 60, 10, 20, 50};
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
        if (left < right) {
            int l = left;
            int r = right;
            // 取左边第一个数字为依据
            int x = a[l];

            while (l < r) {
                // 找出右边第一个比x小的数字
                while (l < r && a[r] > x) {
                    r--;
                }
                // 将右边第一个比x小的数字赋值给左边的数字
                if (l < r) {
                    a[l++] = a[r];
                }
                // 找出左边第一个比x大的数字
                while (l < r && a[l] < x) {
                    l++;
                }
                // 将左边第一个比x大的数字赋值给右边的数字
                if (l < r) {
                    a[r--] = a[l];
                }
            }
            // x放于之间
            if (l < r) {
                a[l] = x;
            }
            quickSort(a, left, l - 1);
            quickSort(a, l + 1, right);
        }

    }
}
