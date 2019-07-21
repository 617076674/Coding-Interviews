package question055;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 运行时间：16ms。占用内存：9524k。
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode cur1 = pHead, cur2 = pHead;
        do {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur2 == null) {
                return null;
            }
            cur2 = cur2.next;
            if (cur2 == null) {
                return null;
            }
        } while (cur1 != cur2);
        cur1 = pHead;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
