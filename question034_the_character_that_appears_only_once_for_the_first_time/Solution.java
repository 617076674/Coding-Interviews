package question034_the_character_that_appears_only_once_for_the_first_time;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为str的长度。
 *
 * 运行时间：58ms。占用内存：9788k。
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int n;
        if (null == str || (n = str.length()) == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}