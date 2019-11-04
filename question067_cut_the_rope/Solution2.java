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
 * 当n >= 5时，我们尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
 *
 * 运行时间：16ms。占用内存：9592k。
 */
public class Solution2 {
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = target / 3;
        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        //此时更好的办法是把绳子剪成长度为2的两段，因为2 * 2 > 3 * 1
        if (target - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}