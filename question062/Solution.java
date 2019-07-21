package question062;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 运行时间：30ms。占用内存：9748k。
 */
public class Solution {
    private TreeNode result = null;

    private int count;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0) {
            return null;
        }
        count = k;
        inOrderTraversal(pRoot);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode || result != null) {
            return;
        }
        inOrderTraversal(treeNode.left);
        if (--count == 0) {
            result = treeNode;
        }
        inOrderTraversal(treeNode.right);
    }
}
