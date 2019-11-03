package question051_building_a_product_array;

/**
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为数组A的长度。
 *
 * 运行时间：15ms。占用内存：9172k。
 */
public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        if (n == 0 || n == 1) {
            return B;
        }
        int[] array1 = new int[n], array2 = new int[n];
        array1[0] = A[0];
        for (int i = 1; i < n; i++) {
            array1[i] = array1[i - 1] * A[i];
        }
        array2[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            array2[i] = array2[i + 1] * A[i];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                B[i] = array2[1];
            } else if (i == n - 1) {
                B[i] = array1[n - 2];
            } else {
                B[i] = array1[i - 1] * array2[i + 1];
            }
        }
        return B;
    }
}