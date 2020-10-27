package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description: 496.下一个更大元素1⃣️
 * //给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
 * //比其大的值。
 * //
 * // nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * // 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * //输出: [-1,3,-1]
 * //解释:
 * //    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * //    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * //    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * //
 * // 示例 2:
 * //
 * // 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * //输出: [3,-1]
 * //解释:
 * //    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * //    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // nums1和nums2中所有元素是唯一的。
 * // nums1和nums2 的数组大小都不超过1000。
 * //
 * // Related Topics 栈
 * // 👍 291 👎 0
 * @Author: liuye
 * @time: 2020/10/27$ 下午9:37$
 */
public class NextGreaterElement496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //先找出数组2每个元素对应的值
        int num2Size = nums2.length;
        int num1Size = nums1.length;
        int[] resp = new int[num1Size];
        int[] res = new int[num2Size];
        HashMap< Integer, Integer > map = new HashMap <> ();
        Stack<Integer> stack = new Stack<>();
        //从后往前
        for (int i = num2Size - 1; i >= 0; i--) {
            //栈不为空且当前元素大于栈中元素(即不满足后一元素大于自己当前元素的)，则移除该元素
            //如果此处条件是stack.peek() > nums2[i],则while循环不应该做操作，但是这样不满足场景，则没有移除不满足的元素
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                 stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], res[i]);
            //元素入栈
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            resp[i] = map.get(nums1[i]);
        }
        return resp;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }
}
