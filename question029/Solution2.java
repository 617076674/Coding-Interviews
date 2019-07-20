package question029;

import java.util.ArrayList;

/**
 * @author qianyihui
 * @date 2019-07-20
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
        swap(nums, left, (int) (left + Math.random() * (right - left + 1)));
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
        if (greaterThan - left >= k) {
            for (int j = left; j <= greaterThan - 1 && j < k + left; j++) {
                list.add(nums[j]);
            }
        } else {
            for (int j = left; j <= greaterThan - 1; j++) {
                list.add(nums[j]);
            }
            list.addAll(quickSort(nums, greaterThan, right, k - (greaterThan - left)));
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(new Solution2().GetLeastNumbers_Solution(array, 4));
    }
}
