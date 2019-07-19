package question011;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 运行时间：23ms。占用内存：9448k。
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
