package question052_regular_expression_matching;

/**
 * https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 状态定义：dp[i][j] -------- 字符串str中[0, i - 1]的子串能否匹配字符串pattern中[0, j - 1]中的子串
 *
 * 状态转移：
 * （1）dp[0][0] = true
 * （2）dp[i][0] = false
 * （3）dp[0][j]，当j是偶数时的pattern[j - 1]为*，此时为true，否则为false。
 * （4）dp[i][j]，当pattern[j - 1]为*时
 *                     当str[i - 1]与pattern[j - 2]相匹配时，dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
 *                     当str[i - 1]与pattern[j - 2]不匹配时，dp[i][j] = dp[i][j - 2];
 *               当pattern[j - 1]为.时，dp[i][j] = dp[i - 1][j - 1]
 *               当pattern[j - 1]与str[i - 1]匹配时，dp[i][j] = dp[i - 1][j - 1]
 *               当pattern[j - 1]与str[i - 1]不匹配时，false
 *
 * 时间复杂度和空间复杂度均是O(mn)。
 *
 * 运行时间：41ms。占用内存：10264k。
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = false;
        }
        boolean flag = true;
        for (int i = 1; i < n + 1; i++) {
            if ((i & 1) == 0) {
                if (pattern[i - 1] == '*') {
                    if (flag) {
                        dp[0][i] = true;
                    }
                } else {
                    flag = false;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (pattern[j - 1] == '*') {
                    if (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}