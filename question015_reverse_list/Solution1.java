package question015_reverse_list;

/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 非递归实现。
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 运行时间：18ms。占用内存：9452k。
 */
public class Solution1 {
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