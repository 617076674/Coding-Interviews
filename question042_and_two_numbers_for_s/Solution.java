package question042_and_two_numbers_for_s;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 左右双指针。
 *
 * 时间复杂度是O(n)，其中n为array数组的长度。空间复杂度是O(1)。
 *
 * 运行时间：15ms。占用内存：8964k。
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (sum == array[left] + array[right]) {
                result.add(array[left]);
                result.add(array[right]);
                return result;
            } else if (sum < array[left] + array[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}