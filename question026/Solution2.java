package question026;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 运行时间：23ms。占用内存：9188k。
 */
public class Solution2 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode leftList = Convert(pRootOfTree.left);
        if (leftList != null) {
            TreeNode cur = leftList;
            while (cur.right != null) {
                cur = cur.right;
            }
            pRootOfTree.left = cur;
            cur.right = pRootOfTree;
        } else {
            pRootOfTree.left = null;
        }
        TreeNode rightResult = Convert(pRootOfTree.right);
        pRootOfTree.right = rightResult;
        if (rightResult != null) {
            rightResult.left = pRootOfTree;
        }
        return leftList == null ? pRootOfTree : leftList;
    }
}
