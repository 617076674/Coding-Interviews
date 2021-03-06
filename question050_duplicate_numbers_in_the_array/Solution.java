package question050_duplicate_numbers_in_the_array;

/**
 * https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 时间复杂度是O(length)。空间复杂度是O(1)。
 *
 * 运行时间：26ms。占用内存：9408k。
 */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    //    so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (i != numbers[i] && numbers[numbers[i]] != numbers[i]) {
                swap(numbers, i, numbers[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (i != numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}