package com.zeek.algorithmtest;

/**
 * @ClassName Solution
 * @Description https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/21/
 * @Author liweibo
 * @Date 2020/5/9 1:54 下午
 * @Version v1.0
 **/
class Solution {
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        boolean flag = false;
        int count = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            for( ;j < count; j++) {
                if(nums[j] == nums[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
                nums[count-1] = nums[i];

            }
            flag = false;
            j = 0;
        }

        return count;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public static void main(String[] args) {

        int i = Solution.removeDuplicates2(new int[]{1, 1, 2});
        System.out.println(i);

    }
}
