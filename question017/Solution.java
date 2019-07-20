package question017;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 运行时间：26ms。占用内存：9420k。
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSubTree(root1, root2)) {
            return true;
        }
        if (HasSubtree(root1.left, root2)) {
            return true;
        }
        return HasSubtree(root1.right, root2);
    }

    /**
     * root2是否是root1的自根节点开始的子树
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
