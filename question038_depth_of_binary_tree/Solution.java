package question038_depth_of_binary_tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 运行时间：17ms。占用内存：9432k。
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}