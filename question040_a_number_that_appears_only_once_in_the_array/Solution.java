package question040_a_number_that_appears_only_once_in_the_array;

/**
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 运行时间：20ms。占用内存：9464k。
 */
public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int num1XORNum2 = 0;
        for (int i = 0; i < array.length; i++) {
            num1XORNum2 ^= array[i];
        }
        num1XORNum2 &= -num1XORNum2;
        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & num1XORNum2) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}