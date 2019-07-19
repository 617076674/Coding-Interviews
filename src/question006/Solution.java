package question006;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 运行时间：271ms。占用内存：28664k。
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int index1 = 0, index2 = n - 1, indexMid = index1;
        //一般来说，array[index1] >= array[index2]，但有特例，即未旋转的数组，如[1, 2, 3, 4, 5]，此时直接返回array[index1]即可
        while (array[index1] >= array[index2]) {
            //如果index1和index2只相差1，此时index1已指向第一个递增子数组的最后一个元素
            //index2已指向第二个递增子数组的第一个元素，直接返回array[index2]即可
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = index1 + ((index2 - index1) >> 1);   //取index1和index2的中值
            if (array[index1] == array[index2] && array[indexMid] == array[index1]) {
                //因为数组中的元素有可能相同，这种情况对应于[1, 0, 1, 1, 1]和[1, 1, 1, 0, 1]这样的情形，只能遍历所有元素求最小值
                int min = index1;
                for (int i = index1 + 1; i <= index2; i++) {
                    if (array[i] < array[min]) {
                        min = i;
                    }
                }
                return array[min];
            }
            if (array[indexMid] >= array[index1]) {
                //说明array[indexMid]处于第一个数组中
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                //说明array[indexMid]处于第二个数组中
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }
}