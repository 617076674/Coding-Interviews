package question032_arrange_the_array_to_the_smallest_number;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 贪心算法。
 *
 * 根据题目的要求，两个数字m和n能拼接成数字mn和nm，如果mn < nm，那么我们应该打印出mn，也就是m应该排在n的前面，我们定义此时m小于n；反之，
 * 如果nm < mn，则我们定义n小于m；如果mn = nm，则m等于n。
 *
 * 我们先把数组中的整数转换成字符串，然后在自定义上述比较规则，最后把排好序的数组中的数字依次打印出来，就是该数组中数字能拼接出来的最小数字。
 *
 * 上述贪心策略的证明（反证法）：
 *
 * 我们把n个数按照前面的排序规则排序之后，表示为A1 A2 A3 ... An。假设这样拼接出来的数字并不是最小的，即至少存在两个x和y(0 < x < y < n)，
 * 交换第x个数和第y个数后，A1 A2 ... Ay ... Ax ... An < A1 A2 ... Ax ... Ay ... An。
 *
 * 由于A1 A2 ... Ax ... Ay ... An是按照前面的规则排好的序列，所以有Ax小于A(x + 1)小于A(x + 2)小于...小于A(y - 2)小于A(y - 1)小于Ay。
 *
 * 由于A(y - 1)小于Ay，所以A(y - 1) Ay < Ay A(y - 1)。我们在序列A1 A2 ... Ax ... A(y - 1) Ay ... An中交换A(y - 1)和Ay，有
 * A1 A2 ... Ax ... A(y - 1) Ay ... An < A1 A2 ... Ax ... Ay A(y - 1) ... An。我们就这样一直把Ay和前面的数字交换，直到和Ax交换
 * 为止。于是就有A1 A2 ... Ax ... A(y - 1) Ay ... An < A1 A2 ... Ax ... Ay A(y - 1) ... An <
 * A1 A2 ... Ax ... Ay A(y - 2) A(y - 1) ... An < ... < A1 A2 ... Ay Ax ... A(y - 2) A(y - 1) ... An。
 *
 * 同理，由于Ax < A(x + 1)，所以Ax A(x + 1) < A(x + 1) Ax。我们在序列A1 A2 ... Ay Ax A(x + 1) ... A(y - 2) A(y - 1) ... An中
 * 只交换Ax和A(x + 1)，有A1 A2 ... Ay Ax A(x + 1) ... A(y - 2) A(y - 1) ... An <
 * A1 A2 ... Ay A(x + 1) Ax ... A(y - 2) A(y - 1) ... An。接下来一直拿Ax和它后面的数字交换，直到和A(y - 1)交换为止。于是就有
 * A1 A2 ... Ay Ax A(x + 1) ... A(y - 2) A(y - 1) ... An < A1 A2 ... Ay A(x + 1) Ax ... A(y - 2) A(y - 1) ... An < ... <
 * A1 A2 ... Ay A(x + 1) A(x + 2) ... A(y - 2) A(y - 1) Ax ... An。
 *
 * 所以A1 A2 ... Ax ... Ay ... An < A1 A2 ... Ay ... Ax ... An。这和我们的假设
 * A1 A2 ... Ay ... Ax ... An < A1 A2 ... Ax ... Ay ... An相矛盾。所以假设不成立，我们的算法是正确的。
 *
 * 时间复杂度是O(nlogn)，其中n是numbers数组的长度。空间复杂度是O(1)。
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