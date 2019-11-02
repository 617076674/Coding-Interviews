package question037_the_number_of_times_the_array_appears_in_the_sorted_array;

/**
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 时间复杂度是O(nlogn)，其中n是array数组的长度。空间复杂度是O(1)。
 *
 * 运行时间：14ms。占用内存：9412k。
 */
public class Solution {
    public int GetNumberOfK(int[] array , int k) {
        int start = floor(array, k);
        if (start == -1) {
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
        return -1;
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
        return -1;
    }
}