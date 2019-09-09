package question061;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
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
        preOrder.append(",");
        preOrder.append(treeNode.val);
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
