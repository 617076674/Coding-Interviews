package question053;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 运行时间：19ms。占用内存：9252k。
 */
public class Solution {
    private int index;

    public boolean isNumeric(char[] str) {
        int n;
        if (null == str || (n = str.length) == 0) {
            return false;
        }
        boolean numeric = scanInteger(str);
        if (index < n && str[index] == '.') {
            index++;
            //1.小数可以没有整数部分，如.123等于0.123
            //2.小数点后面可以没有数字，如233.等于233.0
            //3.小数点前面和后面可以都有数字，如233.666
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (index < n && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            //1.当e或E前面没有数字时，制衡个字符串不能表示数字，如.e1、e1
            //2.当e或E后面没有整数时，整个字符串不能表示数字，如12e、12e+5.4
            numeric = numeric && scanInteger(str);
        }
        return numeric && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int tmp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > tmp;
    }
}
