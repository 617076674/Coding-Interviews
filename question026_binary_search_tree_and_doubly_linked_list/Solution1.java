package question026_binary_search_tree_and_doubly_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 中序遍历后重新设置指针的指向。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
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