package question018_mirror_of_a_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 非递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 运行时间：22ms。占用内存：9732k。
 */
public class Solution1 {
    public void Mirror(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
    }
}