package question063;

import java.util.PriorityQueue;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 运行时间：156ms。占用内存：15112k。
 */
public class Solution {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private int size = 0;

    public void Insert(Integer num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(num);
        } else if (maxHeap.size() == minHeap.size()) {
            if (num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            if (minHeap.isEmpty()) {
                if (num < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            } else {
                if (num < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }
        size++;
    }

    public Double GetMedian() {
        if ((size & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return Double.valueOf(maxHeap.peek());
        }
    }
}
