package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * @Author: liuye
 * @time: 2022/5/24$ 10:01 下午$
 */
public class DiameterOfBinaryTree504 {

    public int maxDiameter = 0;

    /**
     * 很容易理解为最大直径 就是根节点最大左子直径 + 最大右子直径，
     * 但其实不是，最大直径可能不经过根节点，所以需要每个节点遍历。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //前序位置处理
        int leftMax = getMax(root.left, 0);
        int rightMax = getMax(root.right, 0);
        maxDiameter = Math.max(leftMax + rightMax, maxDiameter);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return maxDiameter;
    }

    /**
     * 获取二叉树最大深度
     *
     * @param root
     * @param max
     * @return
     */
    private int getMax(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        max++;
        int leftMax = getMax(root.left, max);
        int rightMax = getMax(root.right, max);
        return Math.max(leftMax, rightMax);
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return maxDiameter > 0 ? maxDiameter - 1 : 0;
    }

    /**
     * 返回节点出发最大深度，同时会计算出连接左右节点最大深度(即经过该节点的最大深度)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //左节点 + 右节点 + 1: 所有节点
        maxDiameter = Math.max(maxDiameter, right + left + 1);
        //返回对应节点的最大深度
        return Math.max(left, right) + 1;
    }

}
