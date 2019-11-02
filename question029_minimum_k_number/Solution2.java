package question029_minimum_k_number;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 *
 * 快排。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为input数组的长度。
 *
 * 运行时间：24ms。占用内存：9784k。
 */
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        return quickSort(input, 0, input.length - 1, k);
    }

    private ArrayList<Integer> quickSort(int[] nums, int left, int right, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }
        if (left == right && k == 1) {
            list.add(nums[left]);
            return list;
        }
        swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
        //[left + 1, lessThan] [lessThan + 1, i) [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] > nums[left]) {
                greaterThan--;
                swap(nums, i, greaterThan);
            } else {
                lessThan++;
                swap(nums, i, lessThan);
                i++;
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        if (k == lessThan - left + 1) {
            for (int j = left; j <= lessThan; j++) {
                list.add(nums[j]);
            }
        } else if (k < lessThan - left + 1) {
            list.addAll(quickSort(nums, left, lessThan, k));
        } else if (k > lessThan - left + 1 && k <= greaterThan - left) {
            for (int j = left; j < k + left; j++) {
                list.add(nums[j]);
            }
        } else {
            for (int j = left; j <= greaterThan - 1; j++) {
                list.add(nums[j]);
            }
            list.addAll(quickSort(nums, greaterThan, right, k - greaterThan + left));
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}