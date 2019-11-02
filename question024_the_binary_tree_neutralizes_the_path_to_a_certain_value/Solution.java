package question024_the_binary_tree_neutralizes_the_path_to_a_certain_value;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 *
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 回溯法。
 *
 * 时间复杂度O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 运行时间：32ms。占用内存：9540k。
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (null == root) {
            return result;
        }
        dfs(root, target);
        return result;
    }

    private void dfs(TreeNode root, int target) {
        if (null == root.left && null == root.right && target == root.val) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (null != root.left) {
            list.add(root.val);
            dfs(root.left, target - root.val);
            list.remove(list.size() - 1);
        }
        if (null != root.right) {
            list.add(root.val);
            dfs(root.right, target - root.val);
            list.remove(list.size() - 1);
        }
    }
}