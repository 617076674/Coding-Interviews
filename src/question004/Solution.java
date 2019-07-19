package question004;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 运行时间：217ms。占用内存：23052k。
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int k = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == pre[preLeft]) {
                k = i;
                break;
            }
        }
        int numLeft = k - inLeft;
        root.left = reConstructBinaryTree(pre, in, preLeft + 1, k - inLeft + preLeft, inLeft, k - 1);
        root.right = reConstructBinaryTree(pre, in, k - inLeft + preLeft + 1, preRight, k + 1, inRight);
        return root;
    }
}
