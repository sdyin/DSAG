package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2023/7/15$ 12:44 下午$
 */
public class IsValidBST_98 {

    // 由于BST(二叉搜索树)的规则是所有左子树的值都小于父节点以及其祖先节点，所以不能简单分解比较每个子树的根节点和左右子节点的值
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // base case
        if(node == null){
            return true;
        }
        // 不满足条件
        if(min != null && node.val <= min){
            return false;
        }
        if (max != null && node.val >= max){
            return false;
        }
        // 递归
        Boolean boo = isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        return boo;
    }
}
