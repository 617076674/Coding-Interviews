package question017_substructure_of_the_tree;

/**
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 时间复杂度是O(n1 * n2)，其中n1为树root1中的节点个数，n2为树root2中的节点个数。空间复杂度是O(max(h1, h2))，其中h1为树
 * root1的高度，h2为树h2的高度。
 *
 * 运行时间：14ms。占用内存：9276k。
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSubTree(root1, root2)) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
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