package question013;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 归并排序。
 *
 * 运行时间：18ms。占用内存：9156k。
 */
public class Solution {
    public void reOrderArray(int[] array) {
        int n = array.length;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += 2 * sz) {
                merge(array, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
            }
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = array[i];
        }
        int index1 = left, index2 = mid + 1;
        for (int i = left; i <= right; i++) {
            if (index1 > mid) {
                array[i] = aux[index2 - left];
                index2++;
            } else if (index2 > right) {
                array[i] = aux[index1 - left];
                index1++;
            } else if ((aux[index1 - left] & 1) == 1) {
                array[i] = aux[index1 - left];
                index1++;
            } else if ((aux[index2 - left] & 1) == 1){
                array[i] = aux[index2 - left];
                index2++;
            } else {
                array[i] = aux[index1 - left];
                index1++;
            }
        }
    }
}
