package question056_delete_duplicate_nodes_in_the_linked_list;

/**
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 时间复杂度是O(n)，其中n是链表的长度。空间复杂度是O(1)。
 *
 * 运行时间：22ms。占用内存：9560k。
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if (null == pHead || null == pHead.next) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode cur1 = dummyHead, cur2 = cur1.next, cur3 = cur2.next;
        while (true) {
            while (null != cur3 && cur3.val == cur2.val) {
                cur3 = cur3.next;
            }
            if (cur3 != cur2.next) {
                cur1.next = cur3;
            } else {
                cur1 = cur2;
            }
            if (null == cur1.next) {
                return dummyHead.next;
            }
            cur2 = cur1.next;
            if (null == cur2.next) {
                return dummyHead.next;
            }
            cur3 = cur2.next;
        }
    }
}