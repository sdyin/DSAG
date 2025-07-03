package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * leetcode.105 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * @Author: liuye
 * @time: 2025/7/3$ 15:30$
 */
/*
✅ 解题思路
**前序遍历（Preorder）**的顺序是：根节点 -> 左子树 -> 右子树

**中序遍历（Inorder）**的顺序是：左子树 -> 根节点 -> 右子树

利用这个性质，我们可以：

在前序遍历中拿到当前子树的根节点；
在中序遍历中定位根节点的位置，左边是左子树，右边是右子树；
递归处理左子树和右子树。
*/
public class BuildTree105_2 {


    // 中序遍历映射，用于快速定位根节点在中序遍历中的位置
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建中序索引映射，提升查找性能
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // 前序遍历第一个节点是当前子树的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 获取中序遍历中根节点的位置
        int rootIndex = inorderIndexMap.get(rootVal);
        // 左子树节点数量
        int leftSize = rootIndex - inStart;

        // 构建左子树
        // 左子树在前序中的起始位置（跳过根）: preStart + 1
        // 左子树在前序中的结束位置: preStart + leftSize
        // 左子树在中序中的起始位置: inStart
        // 左子树在中序中的结束位置: rootIndex - 1
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1);

        // 构建右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
