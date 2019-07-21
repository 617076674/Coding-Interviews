package question060;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 运行时间：23ms。占用内存：9664k。
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                arrayList.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }

            }
            result.add(arrayList);
        }
        return result;
    }
}
