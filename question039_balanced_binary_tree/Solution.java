package question039_balanced_binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 运行时间：21ms。占用内存：9336k。
 */
public class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (null == root) {
            return 0;
        }
        int result = Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        map.put(root, result);
        return result;
    }
}