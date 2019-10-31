package question011_the_number_of_1_in_the_binary;

/**
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 时间复杂度和空间复杂度均是O(1)。
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