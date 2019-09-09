package question006;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 旋转数组的最小数字。
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 运行时间：271ms。占用内存：28664k。
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1, mid = left;
        //一般来说，array[left] >= array[right]，但有特例，即未旋转的数组，如[1, 2, 3, 4, 5]，此时直接返回array[left]即可
        while (array[left] >= array[right]) {
            //如果left和right只相差1，此时left已指向第一个递增子数组的最后一个元素
            //right已指向第二个递增子数组的第一个元素，直接返回array[right]即可
            if (right - left == 1) {
                return array[mid];
            }
            mid = left + ((right - left) >> 1);   //取left和right的中值
            if (array[left] == array[right] && array[mid] == array[left]) {
                //因为数组中的元素有可能相同，这种情况对应于[1, 0, 1, 1, 1]和[1, 1, 1, 0, 1]这样的情形，只能遍历所有元素求最小值
                int min = left;
                for (int i = left + 1; i <= right; i++) {
                    if (array[i] < array[min]) {
                        min = i;
                    }
                }
                return array[min];
            }
            if (array[mid] >= array[left]) {
                //说明array[indexMid]处于第一个数组中
                left = mid;
            } else if (array[mid] <= array[right]) {
                //说明array[indexMid]处于第二个数组中
                right = mid;
            }
        }
        return array[mid];
    }
}