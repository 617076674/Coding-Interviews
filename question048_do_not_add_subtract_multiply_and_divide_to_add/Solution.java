package question048_do_not_add_subtract_multiply_and_divide_to_add;

/**
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 运行时间：12ms。占用内存：9472k。
 */
public class Solution {
    public int Add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }
}