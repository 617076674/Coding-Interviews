package question049_convert_a_string_to_an_integer;

/**
 * https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 输入描述：
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 输出描述：
 * 如果是合法的数值表达则返回该数字，否则返回0。
 *
 * 运行时间：16ms。占用内存：9284k。
 */
public class Solution {
    public int StrToInt(String str) {
        int n;
        if (null == str || (n = str.length()) == 0) {
            return 0;
        }
        if (n == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        if (str.charAt(0) == '+') {
            return StrToInt(str, 1, n - 1);
        } else if (str.charAt(0) == '-') {
            return -StrToInt(str, 1, n - 1);
        }
        return StrToInt(str, 0, n - 1);
    }

    private int StrToInt(String str, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
            } else {
                return 0;
            }
        }
        return result;
    }
}