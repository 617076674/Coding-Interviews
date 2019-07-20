package question036;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 运行时间：17ms。占用内存：9336k。
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int n1 = getLength(pHead1), n2 = getLength(pHead2);
        if (n1 == 0 || n2 == 0) {
            return null;
        }
        ListNode cur1 = pHead1, cur2 = pHead2;
        if (n1 > n2) {
            for (int i = 0; i < n1 - n2; i++) {
                cur1 = cur1.next;
            }
        } else {
            for (int i = 0; i < n2 - n1; i++) {
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private int getLength(ListNode pHead) {
        int result = 0;
        ListNode cur = pHead;
        while (cur != null) {
            result++;
            cur = cur.next;
        }
        return result;
    }
}
