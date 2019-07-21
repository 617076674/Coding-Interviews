package question049;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 运行时间：16ms。占用内存：9284k。
 */
public class Solution {
    public int StrToInt(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        if (str.charAt(0) == '+') {
            return StrToInt(str, 1, n - 1);
        } else if (str.charAt(0) == '-') {
            return -StrToInt(str, 1, n - 1);
        } else {
            return StrToInt(str, 0, n - 1);
        }
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
