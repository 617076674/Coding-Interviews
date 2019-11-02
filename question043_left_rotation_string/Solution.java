package question043_left_rotation_string;

/**
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * abcXYZdef ---> fedZYXcba ---> XYZdefabc
 *
 * 运行时间：25ms。占用内存：9532k。
 */
public class Solution {
    public String LeftRotateString(String str, int n) {
        int len;
        if (null == str || (len = str.length()) == 0) {
            return "";
        }
        n = n % len;
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String s1 = sb.substring(0, len - n);
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.reverse();
        String s2 = sb.substring(len - n);
        StringBuilder sb2 = new StringBuilder(s2);
        sb2.reverse();
        return sb1.append(sb2).toString();
    }
}