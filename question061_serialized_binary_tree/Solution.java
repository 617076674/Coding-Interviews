package question061_serialized_binary_tree;

/**
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84
 *
 * 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 运行时间：42ms。占用内存：9544k。
 */
public class Solution {
    private StringBuilder preOrder = new StringBuilder();

    private int index = -1;

    String Serialize(TreeNode root) {
        preOrderTraversal(root);
        return preOrder.deleteCharAt(0).toString();
    }

    TreeNode Deserialize(String str) {
        return build(str.split(","));
    }

    private void preOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            preOrder.append(",#");
            return;
        }
        preOrder.append("," + treeNode.val);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    private TreeNode build(String[] strings) {
        index++;
        if(index < strings.length && !strings[index].equals("#")) {
            TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = build(strings);
            root.right = build(strings);
            return root;
        }
        return null;
    }
}