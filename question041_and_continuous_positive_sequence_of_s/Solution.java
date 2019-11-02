package question041_and_continuous_positive_sequence_of_s;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 时间复杂度是O(sum)。空间复杂度是O(1)。
 *
 * 运行时间：19ms。占用内存：9340k。
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 1) {
            return result;
        }
        int left = 1, right = 2, total = 3, mid = (1 + ((sum - 1) >> 1));
        while (left < mid) {
            if (total == sum) {
                addToResult(left, right);
            }
            while (total > sum && left < mid) {
                total -= left;
                left++;
                if (total == sum) {
                    addToResult(left, right);
                }
            }
            right++;
            total += right;
        }
        return result;
    }

    private void addToResult(int left, int right) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            arrayList.add(i);
        }
        result.add(arrayList);
    }
}