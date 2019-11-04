package question062_the_kth_node_of_the_binary_search_tree;

/**
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 运行时间：30ms。占用内存：9748k。
 */
public class Solution {
    private TreeNode result;

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
        if (null == treeNode || null != result) {
            return;
        }
        inOrderTraversal(treeNode.left);
        if (--count == 0) {
            result = treeNode;
        }
        inOrderTraversal(treeNode.right);
    }
}