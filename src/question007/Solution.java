package question007;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 运行时间：18ms。占用内存：9288k。
 */
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int num1 = 0, num2 = 1, num = 0;
        while (--n > 0) {
            num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        return num;
    }
}