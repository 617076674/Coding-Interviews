package question056;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 运行时间：22ms。占用内存：9560k。
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode cur1 = dummyHead, cur2 = dummyHead.next;
        if (cur2 == null) {
            return null;
        }
        ListNode cur3 = cur2.next;
        while (cur3 != null) {
            if (cur3.val != cur2.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
                cur3 = cur3.next;
            } else {
                while (cur3.val == cur2.val) {
                    cur3 = cur3.next;
                    if (cur3 == null) {
                        break;
                    }
                }
                cur1.next = cur3;
                if (cur3 == null) {
                    break;
                }
                cur2 = cur1.next;
                if (cur2 == null) {
                    break;
                }
                cur3 = cur2.next;
            }
        }
        return dummyHead.next;
    }
}
