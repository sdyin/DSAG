package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/10$ 9:28 上午$
 */
public class Search704 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7,8,9};
        int target = 7;
        final int index = search(nums, target);
        System.out.println("index:" +  index);
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;
        //区间前后均闭合
        int left = 0;
        int right = length - 1;
        //此处用小于等于 是因为 left 和 right 都是闭合区间。left==right 时仍然有值
        while (left <= right) {
            int middle = left + (right -left)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target){
                //middle 不匹配，且在右区间。则left右移到 middle+ 1
                left = middle + 1;
            } else if (nums[middle] > target) {
                //middle 不匹配，且在左区间。则right左移到 middle- 1
                right = middle - 1;
            }
        }
        return -1;
    }

    private static int findIndex(int[] nums, int target, int start, int length) {
        int middleIndex = (length + start) / 2;
        if(nums[middleIndex] > target && (length - start) >= 1) {
            return findIndex(nums, target, start, middleIndex + 1);
        }
        if (nums[middleIndex] < target && (length - start) >= 1) {
            return findIndex(nums, target, middleIndex + 1, length);
        }
        if (nums[middleIndex] == target) {
            return middleIndex;
        }
        return -1;
    }
}
