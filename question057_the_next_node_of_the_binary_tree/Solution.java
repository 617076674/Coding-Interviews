package question057_the_next_node_of_the_binary_tree;

/**
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 时间复杂度是O(h)，其中h是树的高度。空间复杂度是O(1)。
 *
 * 运行时间：27ms。占用内存：9624k。
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点。
        if (null != pNode.right) {
            //也就是说，从右子节点出发一直沿着指向左子节点的指针，我们就能找到它的下一个节点。
            TreeLinkNode cur = pNode.right;
            while (null != cur.left) {
                cur = cur.left;
            }
            return cur;
        }
        //走到这里，说明该节点没有右子树。
        //如果节点是它父节点的左子节点，那么它的下一个节点就是它的父节点。
        TreeLinkNode cur = pNode, parent = pNode.next;
        //如果节点是它父节点的右子节点，我们需要沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点。
        //如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点。
        while (null != parent && cur == parent.right) {
            cur = parent;
            parent = parent.next;
        }
        return parent;
    }
}