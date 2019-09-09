package question010;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 运行时间：15ms。占用内存：9236k。
 */
public class Solution {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        int num1 = 1, num2 = 1, num = 0;
        while (--target > 0) {
            num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        return num;
    }
}