package question012;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 注意：exponent可能为0和负数。
 *
 * 运行时间：51ms。占用内存：10216k。
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
        return Power(base, exponent / 2) * Power(base, exponent - exponent / 2);
    }
}
