package question014_the_kth_node_in_the_list;

/**
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 双指针。
 *
 * 时间复杂度是O(max(k, n))，其中n为链表中的节点个数。空间复杂度是O(1)。
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