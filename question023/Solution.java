package question023;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 运行时间：15ms。占用内存：9344k。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
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
