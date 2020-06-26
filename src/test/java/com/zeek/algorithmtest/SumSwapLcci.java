package com.zeek.algorithmtest;

import java.util.Arrays;
import java.util.Collection;

/**
 * @ClassName SumSwapLcci
 * @Description
 * https://leetcode-cn.com/problems/sum-swap-lcci/
 *
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 *
 * 1 <= array1.length, array2.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author liweibo
 * @Date 2020/6/1 7:29 下午
 * @Version v1.0
 **/
public class SumSwapLcci {

    public static void main(String[] args) {

        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};

        int[] array2 = new int[]{3, 6, 3, 3};

        int[] swapValues = SumSwapLcci.findSwapValues(array1, array2);

        Arrays.asList(swapValues).stream().forEach(System.out::print);

    }

    public static int[] findSwapValues(int[] array1, int[] array2) {
        int[] result = new int[0];

        int sum1 = 0;
        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
        }

        int sum2 = 0;
        for (int j = 0; j < array2.length; j++) {
            sum2 += array2[j];
        }

        for (int m = 0; m < array1.length; m++) {
            for (int n = 0; n < array2.length; n++) {
                if ((sum1 - (array1[m] - array2[n])) == (sum2 - (array2[n] - array1[m]))) {
                    result = new int[2];
                    result[0] = array1[m];
                    result[1] = array2[n];
                    break;
                }
            }
        }

        return result;
    }
}
