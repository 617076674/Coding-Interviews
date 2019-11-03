package question047_sum_1_2_3_and_n;

/**
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 运行时间：15ms。占用内存：9496k。
 */
public class Solution {
    public static int Sum_Solution(int n) {
        int sum = n;
        //当n为0时，就不会调用递归函数，而是直接返回sum
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }
}