package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * @Author: liuye
 * @time: 2022/5/24$ 10:01 下午$
 */
public class DiameterOfBinaryTree543 {

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



    public int max = 0;

    /**
     * 二叉树的最大直径对于每个节点来说就是其左右子树的最大深度之和。
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree3(TreeNode root) {
        // 这里不能使用int 类型局部变量，递归过程只对当前栈生效， 不影响外层调用栈的max值， 最终返回始终是0
        // int max = 0
        maxDiameter(root);
        return max;
    }


    /**
     * 递归返回当前节点的最大深度
     *
     * @param node
     * @return
     */
    private int maxDiameter(TreeNode node) {
        // 递归到叶子节点子节点时，返回0
        if (node == null) {
            return 0;
        }
        // 递归计算左右子树的最大深度， 注意这里是最大深度，不是最大直径和
        int leftDepth = maxDiameter(node.left);
        int rightDepth = maxDiameter(node.right);
        // 最大直径为左右子树最大深度之和
        max = Math.max(max, leftDepth + rightDepth);
        // 返回当前节点的最大深度， 实际上也可以表示节点数量
        // 这里需要 +1， 不然每层节点都会返回0， 因为递归到叶子节点时，返回0
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
