package question039;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 运行时间：21ms。占用内存：9336k。
 */
public class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = TreeDepth(root.left);
        int rightHeight = TreeDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        int result = Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        map.put(root, result);
        return result;
    }
}
