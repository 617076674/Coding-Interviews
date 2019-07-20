package question033;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
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
            uglies[i] = Math.min(uglies[index2] * 2, Math.min(uglies[index3] * 3, uglies[index5] * 5));
            if (uglies[i] == uglies[index2] * 2) {
                index2++;
            }
            if (uglies[i] == uglies[index3] * 3) {
                index3++;
            }
            if (uglies[i] == uglies[index5] * 5) {
                index5++;
            }
        }
        return uglies[index - 1];
    }
}
