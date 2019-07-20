package question045;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * 运行时间：16ms。占用内存：9552k。
 */
public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int count0 = 0, gap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count0++;
            } else {
                break;
            }
        }
        for (int i = count0; i < numbers.length; i++) {
            if (i > 1) {
                int diff = numbers[i] - numbers[i - 1];
                if (diff == 0) {
                    return false;
                } else {
                    gap += (diff - 1);
                }
            }
        }
        return count0 >= gap;
    }
}
