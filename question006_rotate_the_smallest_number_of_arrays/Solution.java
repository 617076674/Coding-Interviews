package question006_rotate_the_smallest_number_of_arrays;

/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 时间复杂度是O(logn)，其中n是array数组的长度。空间复杂度是O(1)。
 *
 * 运行时间：271ms。占用内存：28664k。
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1;
        if (array[left] < array[right]) {
            return array[left];
        }
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == array[left] && array[mid] == array[right]) {
                int min = Integer.MAX_VALUE;
                for (int i = left; i <= right; i++) {
                    min = Math.min(min, array[i]);
                }
                return min;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[right];
    }
}