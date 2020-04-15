package com.zeek.algorithmtest;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName InsertSort
 * @Description
 * @Author liweibo
 * @Date 2019/10/10 2:22 PM
 * @Version v1.0
 **/
public class InsertSort {

    public static void main(String[] args) {

        int[] array = {4, 5, 6, 1, 3, 2};
        System.out.println(StringUtils.join(array, ','));

        insertionSort(array, 6);
//        bubbleSort(array);

        System.out.println(StringUtils.join(array, ','));
    }

    // 插入排序，a 表示数组，n 表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    // 我写的插入排序算法
    public static void MyInsertionSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        int n = a.length;

        for (int i = 1; i < n; i++) {
            // 未排序区第一个元素
            int value = a[i];
            // 已经排序区最右边元素
            int j = i - 1;
            //移动元素
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        int n = a.length;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] > a[j]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }

            if(!flag) {
                break;
            }
        }
    }

}
