package question032;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 运行时间：232ms。占用内存：15204k。
 */
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, (o1, o2) -> (o1 + String.valueOf(o2)).compareTo(o2 + String.valueOf(o1)));
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
