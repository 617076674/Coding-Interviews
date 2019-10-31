package question008_jumping_stairs;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 时间复杂度是O(target)。空间复杂度是O(1)。
 *
 * 运行时间：18ms。占用内存：9288k。
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target == 0 || target == 1) {
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