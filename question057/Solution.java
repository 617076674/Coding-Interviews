package question057;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 运行时间：27ms。占用内存：9624k。
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        TreeLinkNode cur = pNode, parent = pNode.next;
        while (parent != null && cur == parent.right) {
            cur = parent;
            parent = parent.next;
        }
        return parent;
    }
}
