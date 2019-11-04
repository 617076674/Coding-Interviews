package question067_cut_the_rope;

/**
 * https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8
 *
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0], k[1], ..., k[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入描述：
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：长度为i的绳子所能得到的最大结果。
 *
 * 状态转移：
 * dp[i] = max(dp[j] * dp[i - j]), j∈[1, i - 1]
 *
 * 时间复杂度是O(target ^ 2)。空间复杂度是O(target)。
 *
 * 运行时间：17ms。占用内存：9356k。
 */
public class Solution1 {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }
}