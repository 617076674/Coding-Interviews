package question037;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 运行时间：14ms。占用内存：9412k。
 */
public class Solution {
    public int GetNumberOfK(int[] array , int k) {
        int start = floor(array, k);
        if (start == -1 || array[start] != k) {
            return 0;
        }
        int end = ceil(array, k);
        return end - start + 1;
    }

    //若比array中最小元素还小，会返回-1
    private int floor(int[] array, int k) {
        int left = -1, right = array.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (array[mid] < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left + 1 < array.length && array[left + 1] == k) {
            return left + 1;
        }
        return left;
    }

    //若比array中最大元素还大，会返回array.length
    private int ceil(int[] array, int k) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && array[left - 1] == k) {
            return left - 1;
        }
        return left;
    }
}
