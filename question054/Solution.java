package question054;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 运行时间：24ms。占用内存：9528k。
 */
public class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    private int index = 0;
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
