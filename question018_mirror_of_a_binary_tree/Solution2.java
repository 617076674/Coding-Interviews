package question018_mirror_of_a_binary_tree;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 运行时间：31ms。占用内存：9536k。
 */
public class Solution2 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.right);
        Mirror(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}