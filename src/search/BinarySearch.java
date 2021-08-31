package search;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/8/26
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 45, 5};
        int[] a = {2,1,3};
        System.out.println(search(a, 3, 0, a.length));
    }

    /**
     * @param a         数组
     * @param num       要找的数字
     * @param lowIndex  低位 位置
     * @param highIndex 高位 位置
     * @return
     */
    public static int search(int[] a, int num, int lowIndex, int highIndex) {
        int mid;

        while (lowIndex < highIndex) {
            mid = (lowIndex + highIndex) >>> 1;  // 除以2
            if (num > a[mid]) {
                lowIndex = mid + 1;
            } else if (num < a[mid]) {
                highIndex = mid - 1;
            } else {
                return mid;
            }
        }
        return lowIndex;
    }
}
