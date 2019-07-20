package question022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
