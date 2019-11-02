package question027_arrangement_of_strings;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 回溯法。
 *
 * 时间复杂度是O(n!)，其中n是输入字符串str的长度。空间复杂度是O(n)。
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