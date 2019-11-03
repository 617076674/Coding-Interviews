package question059_print_binary_trees_in_zigzag_order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 运行时间：27ms。占用内存：9684k。
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (null == pRoot) {
            return result;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                arrayList.add(treeNode.val);
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
            }
            if ((level & 1) == 0) {
                Collections.reverse(arrayList);
            }
            result.add(arrayList);
            level++;
        }
        return result;
    }
}