package question013;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 运行时间：14ms。占用内存：9424k。
 */
public class Solution2 {
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i, tmp = array[i];
            while (j > 0 && (array[j - 1] & 1) == 0 && (tmp & 1) == 1) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }
}
