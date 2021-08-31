package sort.insert;

import java.util.Arrays;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/8/31
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {89, 45, 54, 29, 90, 34, 33};
        System.out.println("before sort:" + Arrays.toString(a));
        shellSort(a);
        System.out.println("after  sort:" + Arrays.toString(a));
    }

    public static void shellSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            int insertIndex = binarySearch(a, cur, 0, i - 1);
            for (int j = i - 1; j > insertIndex - 1; j--) {
                a[j + 1] = a[j];
            }
            a[insertIndex] = cur;
        }
    }

    private static int binarySearch(int[] a, int target, int lowIndex, int highIndex) {
        while (lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            int midValue = a[mid];

            if (target < midValue) {
                highIndex = mid - 1;
            } else if (target > midValue) {
                lowIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return target > a[lowIndex] ? lowIndex + 1 : lowIndex;
    }
}
