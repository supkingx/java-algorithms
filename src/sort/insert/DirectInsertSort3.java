package sort.insert;

import java.util.Arrays;

/**
 * @description: 直接插入排序，在查找插入点的部分使用二分查找法
 * @Date: 2021/8/26
 */
public class DirectInsertSort3 {
    public static void main(String[] args) {
//        int[] a = {89, 45, 54, 29, 90, 34, 33};
        int[] a = {1, 2, 3};
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
            // 当前将要插入的数，无序的第一个
            int cur = array[i];

            // 找到插入点,为什么是i-1，因为i就是cur自己
            int search = search(array, cur, 0, i - 1);
            // 插入点之后的全部后移,包括插入点的值也要后移，所以是>search-1
            // i-1 有序的最后一个
            for (int j = i - 1; j > search - 1; j--) {
                array[j + 1] = array[j];
            }
            // 将当前参数插入到当前值
            array[search] = cur;
        }
    }

    public static int search(int[] a, int num, int lowIndex, int highIndex) {

        while (lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) >>> 1;  // 除以2
            if (num > a[mid]) {
                lowIndex = mid + 1;
            } else if (num < a[mid]) {
                highIndex = mid - 1;
            } else {
                return mid;
            }
        }
        return num > a[lowIndex] ? lowIndex + 1 : lowIndex;
    }
}
