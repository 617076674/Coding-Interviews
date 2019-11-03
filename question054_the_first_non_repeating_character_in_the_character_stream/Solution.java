package question054_the_first_non_repeating_character_in_the_character_stream;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 运行时间：24ms。占用内存：9528k。
 */
public class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    private int index;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, index);
            index++;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int min = Integer.MAX_VALUE;
        char result = '#';
        for (Character c : map.keySet()) {
            if (map.get(c) >= 0 && map.get(c) < min) {
                min = map.get(c);
                result = c;
            }
        }
        return result;
    }
}