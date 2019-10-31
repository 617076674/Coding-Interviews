package question007_fibonacci_sequence;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
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