package question058_symmetric_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 运行时间：25ms。占用内存：9436k。
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll(), node2 = queue.poll();
            if (null == node1 && null == node2) {
                continue;
            }
            if (null == node1 || null == node2) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}