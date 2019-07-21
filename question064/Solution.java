package question064;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * 运行时间：18ms。占用内存：9284k。
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = num.length;
        if (size <= 0 || size > n) {
            return result;
        }
        Deque<Integer> deque = new LinkedList<>();  //deque中存储的是索引
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = size; i < n; i++) {
            result.add(num[deque.getFirst()]);
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && deque.getFirst() <= (i - size)) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        result.add(num[deque.getFirst()]);
        return result;
    }
}
