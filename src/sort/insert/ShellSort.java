package sort.insert;

import java.util.Arrays;

/**
 * @description: 希尔排序，内部插入位置 利用二分查找法
 * @Author: wangchao
 * @Date: 2021/8/31
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] a = {89, 45, 54, 29, 90, 34, 33};
        int[] a = {2, 1, 3};
        System.out.println("before sort:" + Arrays.toString(a));
        shellSort(a);
        System.out.println("after  sort:" + Arrays.toString(a));
    }

    public static void shellSort(int[] a) {
        // gap是步长，每次减为原来的一半
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            // 每个步长 为一组，进行插入排序
            for (int i = 0; i < gap; i++) {
                insertSort(a, i, gap);
            }
        }
    }

    public static void insertSort(int[] a, int ii, int gap) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = ii + gap; i < a.length; i += gap) {
            int cur = a[i];
            int insertIndex = binarySearch(a, cur, 0, i - 1, gap);
            for (int j = i - gap; j > insertIndex - gap; j -= gap) {
                a[j + gap] = a[j];
            }
            a[insertIndex] = cur;
        }
    }

    private static int binarySearch(int[] a, int target, int lowIndex, int highIndex, int gap) {
        while (lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            int midValue = a[mid];

            if (target < midValue) {
                highIndex = mid - gap;
            } else if (target > midValue) {
                lowIndex = mid + gap;
            } else {
                return mid;
            }
        }
        return target > a[lowIndex] ? lowIndex + gap : lowIndex;
    }
}
