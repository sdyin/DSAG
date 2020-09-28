package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.Arrays;

/**
 * @Description: 654.最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * @Author: liuye
 * @time: 2020/9/28$ 下午9:11$
 */
public class MaxTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int max = 0;
        int index = 0;
        //找到最大数值
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);

        treeNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0 ,index));
        treeNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return treeNode;
    }
}
