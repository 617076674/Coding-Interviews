package question029;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 运行时间：119ms。占用内存：14672k。
 */
public class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(input[i]);
            } else if (priorityQueue.peek() > input[i]) {
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
