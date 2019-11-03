package question055_the_entry_node_of_the_ring_in_the_list;

/**
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 双指针。
 *
 * 运行时间：16ms。占用内存：9524k。
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        ListNode cur1 = pHead, cur2 = pHead;
        do {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (null == cur2) {
                return null;
            }
            cur2 = cur2.next;
            if (null == cur2) {
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