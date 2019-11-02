package question022_print_binary_tree_from_top_to_bottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 运行时间：15ms。占用内存：9412k。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }
}