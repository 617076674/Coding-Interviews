package question002;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 运行时间：19ms。占用内存：9584k。
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int n = str.length(), count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        char[] array = new char[count * 2 + n];
        int index = array.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                array[index--] = '0';
                array[index--] = '2';
                array[index--] = '%';
            } else {
                array[index--] = str.charAt(i);
            }
        }
        return String.valueOf(array);
    }
}
