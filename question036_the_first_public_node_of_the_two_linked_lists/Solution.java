package question036_the_first_public_node_of_the_two_linked_lists;

/**
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 双指针。让长链表上的指针先走链表长度差值的步数。
 *
 * 时间复杂度是O(n1 + n2)，其中n1是链表pHead1的长度，n2是链表pHead2的长度。空间复杂度是O(1)。
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
        while (null != cur1) {
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