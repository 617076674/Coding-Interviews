package question003;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 运行时间：30ms。占用内存：9272k。
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
