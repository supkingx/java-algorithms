package recursion.test01;

/**
 * @description:n步台阶，一次只能上1步或2步，共有几种走法？ *
 * * 以下是递归解法，也可以参考循环迭代的解法
 * *
 * * 设f(n)=x，表示有n个台阶时，有x中走法
 * * <p>
 * * - n=1，一步   f(1)=1
 * * - n=2，一步一步 或者 直接两步    f(2)=2
 * * - n=3，
 * * - 先到达f(1)，然后f(1)直接跨2步。
 * * - 先到达f(2)，然后f(2)跨1步。
 * * - 即 f(3) = f(1)+f(2)，表示，到f(1)的走法+到f(2)的走法
 * * - n=4，
 * * - 先到达f(2)，然后从f(2)直接跨2步
 * * - 先到达f(3)，然后f(3)跨1步
 * * - 即 f(4) = f(2)+f(3)，表示到f(2)的走法+到f(3)的走法
 * * - ........
 * * - n=x
 * * - 先到达f(x-2)，然后从f(x-2)直接跨2步
 * * - 先到达f(x-1)，然后f(x-1)直接跨1步
 * * - 即f(x)=f(x-2)+f(x-1)，表示到f(x-2)的走法+到f(x-1)的走法
 * @Author: wangchao
 * @Date: 2022/2/9
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(count(5));
        String a =  "1";
        StringBuilder aa = new StringBuilder();
        aa.append("1");
        System.out.println(a.concat("1"));
    }

    public static int count(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return count(n - 1) + count(n - 2);
    }
}
