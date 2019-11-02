package question035_reverse_order_in_array;

/**
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 归并排序。
 *
 * 时间复杂度是O(nlogn)，其中n为array数组的长度。空间复杂度是O(n)。
 *
 * 行时间：486ms。占用内存：53424k。
 */
public class Solution {
    private int result = 0;

    public int InversePairs(int[] array) {
        int n = array.length;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += sz * 2) {
                merge(array, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
            }
        }
        return result;
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = array[i];
        }
        int index1 = mid, index2 = right;
        for (int i = right; i >= left; i--) {
            if (index1 < left) {
                array[i] = aux[index2 - left];
                index2--;
            } else if (index2 <= mid) {
                array[i] = aux[index1 - left];
                index1--;
            } else if (aux[index1 - left] > aux[index2 - left]) {
                result += index2 - mid;
                result %= 1000000007;
                array[i] = aux[index1 - left];
                index1--;
            } else {
                array[i] = aux[index2 - left];
                index2--;
            }
        }
    }
}