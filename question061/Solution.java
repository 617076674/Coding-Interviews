package question061;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 运行时间：42ms。占用内存：9544k。
 */
public class Solution {
    private StringBuilder preOrder = new StringBuilder();

    private int index = -1;

    String Serialize(TreeNode root) {
        preOrderTraversal(root);
        preOrder.deleteCharAt(0);
        return preOrder.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return build(strings);
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
