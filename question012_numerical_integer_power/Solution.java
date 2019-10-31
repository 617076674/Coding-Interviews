package question012_numerical_integer_power;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 注意：exponent可能为0和负数。
 *
 * 时间复杂度和空间复杂度均是O(log(exponent))。
 *
 * 运行时间：36ms。占用内存：10440k。
 */
public class Solution {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            return 1.0 / Power(base, -exponent);
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        int half = exponent >> 1;
        double tmp = Power(base, half);
        if ((exponent & 1) == 0) {
            return tmp * tmp;
        }
        return tmp * tmp * base;
    }
}