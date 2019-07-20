package question015;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 运行时间：18ms。占用内存：9452k。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead.next, cur2 = cur1.next;
        while (cur2 != null) {
            cur1.next = cur2.next;
            ListNode tmp = dummyHead.next;
            dummyHead.next = cur2;
            cur2.next = tmp;
            cur2 = cur1.next;
        }
        return dummyHead.next;
    }
}
