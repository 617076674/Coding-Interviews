package question023_post_order_traversal_sequence_of_binary_search_tree;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 时间复杂度是O(n ^ 2)，其中n为sequence数组的长度。空间复杂度是O(n)。
 *
 * 运行时间：15ms。占用内存：9344k。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int n;
        if (null == sequence || (n = sequence.length) == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, n - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
        if (right == left) {
            return true;
        }
        int index = left;
        while (sequence[index] < sequence[right]) {
            index++;
        }
        for (int i = index; i <= right - 1; i++) {
            if (sequence[i] < sequence[right]) {
                return false;
            }
        }
        if (index == left) {    //此时只有右子树
            return VerifySquenceOfBST(sequence, index, right - 1);
        }
        if (index == right) {   //此时只有左子树
            return VerifySquenceOfBST(sequence, left, index - 1);
        }
        //此时既有左子树又有右子树
        return VerifySquenceOfBST(sequence, left, index - 1) && VerifySquenceOfBST(sequence, index, right - 1);
    }
}