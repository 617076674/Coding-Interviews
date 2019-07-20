package question042;

import java.util.ArrayList;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
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
