package question033_ugly;

/**
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 时间复杂度和空间复杂度均是O(index)。
 *
 * 运行时间：19ms。占用内存：9352k。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] uglies = new int[index];
        uglies[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            int tmp1 = uglies[index2] << 1, tmp2 = uglies[index3] * 3, tmp3 = uglies[index5] * 5;
            uglies[i] = Math.min(tmp1, Math.min(tmp2, tmp3));
            if (uglies[i] == tmp1) {
                index2++;
            }
            if (uglies[i] == tmp2) {
                index3++;
            }
            if (uglies[i] == tmp3) {
                index5++;
            }
        }
        return uglies[index - 1];
    }
}