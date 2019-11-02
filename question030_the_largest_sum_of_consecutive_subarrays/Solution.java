package question030_the_largest_sum_of_consecutive_subarrays;

/**
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 时间复杂度是O(n)，其中n为array数组的长度。空间复杂度是O(1)。
 *
 * 运行时间：12ms。占用内存：9384k。
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n;
        if (null == array || (n = array.length) == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE, sum = array[0];
        for (int i = 1; i < n; i++) {
            sum += array[i];
            result = Math.max(result, sum);
            if (sum < 0) {  //如果sum < 0，则前面的元素均不考虑，重新开始计算和
                sum = 0;
            }
        }
        return result;
    }
}