package question031;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的
 * 数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更
 * 加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 运行时间：19ms。占用内存：9352k。
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        String input = String.valueOf(n);
        int len = input.length(), result = 0;
        if (len == 1) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (input.charAt(i) == '1') {
                    result += Integer.valueOf(input.substring(1)) + 1;
                } else {
                    result += (int) Math.pow(10, len - 1);
                }
            } else if (i == len - 1) {
                if (input.charAt(i) == '0') {
                    result += Integer.valueOf(input.substring(0, len - 1));
                } else {
                    result += Integer.valueOf(input.substring(0, len - 1)) + 1;
                }
            } else {
                if (input.charAt(i) == '0') {
                    result += Integer.valueOf(input.substring(0, i)) * ((int) Math.pow(10, len - i - 1));
                } else if (input.charAt(i) == '1') {
                    result += Integer.valueOf(input.substring(0, i)) * ((int) Math.pow(10, len - i - 1)) + Integer.valueOf(input.substring(i + 1)) + 1;
                } else {
                    result += (Integer.valueOf(input.substring(0, i)) + 1) * ((int) Math.pow(10, len - i - 1));
                }
            }
        }
        return result;
    }
}
