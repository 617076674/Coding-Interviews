package question038;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 运行时间：17ms。占用内存：9432k。
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
