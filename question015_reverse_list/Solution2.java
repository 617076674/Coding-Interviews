package question015_reverse_list;

/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表中的节点个数。
 *
 * 运行时间：18ms。占用内存：9684k。
 */
public class Solution2 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}