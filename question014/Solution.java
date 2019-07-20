package question014;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 运行时间：32ms。占用内存：9576k。
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        while (k-- > 0) {
            cur2 = cur2.next;
            if (cur2 == null) {
                return null;
            }
        }
        while (cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
