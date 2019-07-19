package question009;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 运行时间：19ms。占用内存：9316k。
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        int sum = 3;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = sum + 1;
            sum += dp[i];
        }
        return dp[target - 1];
    }
}
