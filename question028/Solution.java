package question028;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 运行时间：22ms。占用内存：9272k。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int result = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count++;
            } else if (array[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        //众数可能不存在，需要判断求得的数是否是众数
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        return times > (array.length >> 1) ? result : 0;
    }
}
