package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/10$ 3:10 下午$
 */
public class SearchRange34 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        final int[] result = searchRange(nums, target);
        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {

        int length = nums.length;
        //左闭右开
        int left = 0;
        int right = length;
        int left2 = 0;
        int right2 = length;

        //寻找左边界
        while (left < right) {
            int middle = left + (right - left)/2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if ( nums[middle] > target) {
                right = middle;
            } else if (nums[middle] == target) {
                //匹配到元素时,右边界像左移，依次匹配最左边界
                right = middle;
            }
        }

        //寻找右边界
        while(left2 < right2) {
            int middle = left2 + (right2 - left2)/2;
            if(nums[middle] < target) {
                left2 = middle + 1;
            } else if (nums[middle] > target) {
                right2 = middle;
            } else if (nums[middle] == target) {
                //匹配到元素时,左边界右移，依次匹配最右边界
                // 为什么不是left2 = middle 而是 left2 = middle + 1?
                // 个人理解是要让左边界右移，改变左右索引，最终打破while循环。不能左右节点相邻且左节点就是目标元素时，死循环
                left2 = middle + 1;
            }
        }
        int[] result;
        if (left > right2 -1) {
            result = new int[]{-1, -1};
            return result;
        }
        // 为什么是right2 - 1 而不是right2，因为右节点是开节点
        result = new int[]{left, right2 - 1};
        return result;
    }

    /**
     * 拆解二分查找左右边界解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {

        int first = leftBound(nums, target);
        int last = rightBound(nums, target);
        if (first > last) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }

    private int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private int rightBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return right - 1;
    }
}
