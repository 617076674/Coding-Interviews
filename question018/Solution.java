package question018;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 运行时间：22ms。占用内存：9732k。
 */
public class Solution {
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
        return;
    }
}
