package question025_replication_of_complex_linked_lists;

/**
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 时间复杂度是O(n)，其中n是链表中的节点个数。空间复杂度是O(1)。
 *
 * 运行时间：21ms。占用内存：9536k。
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        return seperateList(setRandomPoints(doubleList(pHead)));
    }

    private RandomListNode doubleList(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while (null != cur) {
            RandomListNode tmp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = tmp;
            cur = tmp;
        }
        return pHead;
    }

    private RandomListNode setRandomPoints(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while (null != cur) {
            if (null != cur.random) {   //注意random指针可能为空！！！
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        return pHead;
    }

    /**
     * 原链表不能被修改！！！
     */
    private RandomListNode seperateList(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur1 = pHead, cur2 = pHead.next;
        while (cur1.next != null) {
            RandomListNode tmp = cur1.next;
            cur1.next = cur1.next.next;
            cur1 = tmp;
        }
        return cur2;
    }
}