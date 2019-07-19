package question001;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 时间复杂度是O(m + n)，其中m是array数组的行数，n是array数组的列数。
 *
 * 运行时间：230ms。占用内存：17400k。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        if (m == 0) {
            return false;
        }
        int n = array[0].length;
        if (n == 0) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
