package com.zeek.algorithmtest;

/**
 * @ClassName BinarySearchTest
 * @Description 二分法查找
 * @Author liweibo
 * @Date 2019/10/28 3:54 PM
 * @Version v1.0
 **/
public class BinarySearchTest {

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 5, 7, 9};
        int index = BinarySearchTest.binarySearch(array, array.length, 17);
        System.out.println(index);

        int index2 = BinarySearchTest.binarySearchRecursion(array, array.length, 7);
        System.out.println(index2);
    }

    /**
     * @Description: 二分查找递归形式
     *
     *
     *
     * search(int[] array, int start, int end, int target)
     *
     *
     *
     * @Author: liweibo 
     * @Date: 2019/10/28 4:16 PM
     * @Version: v1.0
     *
     * @Param null
     * 
     * @Return:
     **/
    public static int binarySearchRecursion(int[] array, int n, int target) {

        return search(array, 0, n-1, target);

    }

    public static int search(int[] array, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        if (array[mid] == target) {
            return mid;
        }else if(array[mid] < target) {
            low = mid + 1;
            return search(array, low, high, target);
        }else {
            high = mid - 1;
            return search(array, low, high, target);
        }

    }

    

    // 二分查找非递归形式
    public static int binarySearch(int[] array, int n, int target) {

        int low = 0;
        int high = n - 1;


        while (low <= high) {

            // 当low和high比较大的话，两者之和有可能会溢出
//            int mid = (low + high) / 2;
            //优化为
//            int mid = low + (high - low) / 2;
            //由于除法的性能不如通过位移来进行除，将除以2优化为位移
            int mid = low + ((high - low) >> 1);

            if (array[mid] == target) {
                return mid;
            }else if (array[mid] < target) {
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }

        return -1;
    }
}
