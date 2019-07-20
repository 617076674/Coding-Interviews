package question027;

import java.util.ArrayList;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 运行时间：179ms。占用内存：14132k。
 */
public class Solution {
    private ArrayList<String> result = new ArrayList<>();

    private int[] map = new int[52];

    private int size;

    public ArrayList<String> Permutation(String str) {
        if (null == str) {
            return result;
        }
        size = str.length();
        if (size == 0) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                map[c - 'A' + 26]++;
            }
        }
        Permutation(new StringBuilder());
        return result;
    }

    private void Permutation(StringBuilder sb) {
        if (size == sb.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                map[i]--;
                if (i <= 25) {
                    sb.append((char) ('a' + i));
                    Permutation(sb);
                } else {
                    sb.append((char) ('A' + i));
                    Permutation(sb);
                }
                map[i]++;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
