package question002_replace_space;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 时间复杂度是O(n)，其中n为字符串str的长度。空间复杂度是O(count * 2 + n)，其中count为字符串str中的空格数。
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
        char[] array = new char[(count << 1) + n];
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