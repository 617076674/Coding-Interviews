package question026_binary_search_tree_and_doubly_linked_list;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 运行时间：23ms。占用内存：9188k。
 */
public class Solution2 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        TreeNode leftList = Convert(pRootOfTree.left), rightList = Convert(pRootOfTree.right);
        pRootOfTree.right = rightList;
        if (null != rightList) {
            rightList.left = pRootOfTree;
        }
        if (null != leftList) {
            TreeNode tmp = leftList;
            while (null != tmp.right) {
                tmp = tmp.right;
            }
            tmp.right = pRootOfTree;
            pRootOfTree.left = tmp;
            return leftList;
        }
        return pRootOfTree;
    }
}