package question044;

/**
 * @author qianyihui
 * @date 2019-07-20
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的
 * 顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 运行时间：18ms。占用内存：9540k。
 */
public class Solution {
    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                result.append(tmp.reverse());
                result.append(' ');
                tmp = new StringBuilder();
            } else {
                tmp.append(sb.charAt(i));
            }
        }
        result.append(tmp.reverse());   //别落了加上
        return result.toString();
    }
}
