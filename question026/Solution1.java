package question026;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 运行时间：32ms。占用内存：9348k。
 */
public class Solution1 {
    private List<TreeNode> inOrder = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        inOrderTraversal(pRootOfTree);
        inOrder.get(0).left = null;
        inOrder.get(inOrder.size() - 1).right = null;
        for (int i = 0; i < inOrder.size() - 1; i++) {
            inOrder.get(i).right = inOrder.get(i + 1);
        }
        for (int i = 1; i < inOrder.size(); i++) {
            inOrder.get(i).left = inOrder.get(i - 1);
        }
        return inOrder.get(0);
    }

    private void inOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root);
        inOrderTraversal(root.right);
    }
}
