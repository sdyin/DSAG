package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @Author: liuye
 * @time: 2023/9/11$ 3:09 下午$
 */
public class LowestCommonAncestor_236 {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * dfs
     * 返回一个布尔值，表示子树中是否包含p节点或q节点,注意：这里是子树是否包含p 或者 q，不是p 而且q
     * 考虑一种情况：如果p是q的父节点，那么p的子树就只包含q，而不包含p。在这种情况下，如果我们只检查子树是否同时包含p和q，那么我们就无法找到p和q的最近公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 当前节点的左子树（lson）和右子树（rson）都包含p或q，那么当前节点就是p和q的最近公共祖先。
        // 或者 当前节点就是p或q，并且它的左子树或右子树包含另一个节点，那么当前节点也是p和q的最近公共祖先。
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        // 左子树或者右子树包含p和q, 或者 当前节点本身就是p或者q
        return lson || rson || (root.val == p.val || root.val == q.val);
    }


    /**
     * 时间复杂度 O(N)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左右节点递归查找
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        // 左右节点都不为空，该节点就是LCA
        if (left != null && right != null) {
            return root;
        }
        // 只有一边找到了，返回找到的那边
        // 如果左右节点都没找到，则返回null
        return left != null ? left : right;
    }
}
