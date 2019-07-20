package question043;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 运行时间：25ms。占用内存：9532k。
 */
public class Solution {
    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() == 0) {
            return "";
        }
        n = n % str.length();
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String s1 = sb.substring(0, str.length() - n);
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.reverse();
        String s2 = sb.substring(str.length() - n);
        StringBuilder sb2 = new StringBuilder(s2);
        sb2.reverse();
        return sb1.append(sb2).toString();
    }
}
