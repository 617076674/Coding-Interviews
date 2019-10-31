package question016_combine_two_sorted_linked_lists;

/**
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 时间复杂度是O(n1 + n2)，其中n1是链表list1的长度，n2是链表list2的长度。空间复杂度是O(1)。
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