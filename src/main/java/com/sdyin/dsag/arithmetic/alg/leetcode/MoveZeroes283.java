package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 283.移动零
 * //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * //
 * // 示例:
 * //
 * // 输入: [0,1,0,3,12]
 * //输出: [1,3,12,0,0]
 * //
 * // 说明:
 * //
 * //
 * // 必须在原数组上操作，不能拷贝额外的数组。
 * // 尽量减少操作次数。
 * //
 * // Related Topics 数组 双指针
 * // 👍 772 👎 0
 * @Author liuye
 * @Date 2020/10/16 23:23
 **/
public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        //补全后面位数0
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }

    }
}
