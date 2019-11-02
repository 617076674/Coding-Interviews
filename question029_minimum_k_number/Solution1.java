package question029_minimum_k_number;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 *
 * 优先队列。
 *
 * 时间复杂度是O(nlogk)，其中n是input数组的长度。空间复杂度是O(k)。
 *
 * 运行时间：119ms。占用内存：14672k。
 */
public class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.add(input[i]);
            } else if (pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
