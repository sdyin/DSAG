package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 提示:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 *
 * 中序遍历（inorder）：左子树 → 根 → 右子树
 * 后序遍历（postorder）：左子树 → 右子树 → 根
 *
 * 所以：
 * 后序遍历的最后一个元素是当前子树的根节点；
 * 在中序中定位根节点的位置，左边的是左子树，右边的是右子树；
 * 然后递归左右子树构建。
 *
 * @Author: liuye
 * @time: 2025/7/3$ 17:53$
 */
public class BuildTree106_2 {

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 构造中序索引查找表，避免每次查找
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;

        // 后序遍历的最后一个节点是当前子树的根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 找到中序中的根节点位置
        int rootIndex = inorderIndexMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        // 构建左子树
        root.left = build(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);

        // 构建右子树
        root.right = build(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
