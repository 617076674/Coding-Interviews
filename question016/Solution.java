package question016;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 运行时间：23ms。占用内存：9488k。
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode cur1 = list1, cur2 = list2, dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
