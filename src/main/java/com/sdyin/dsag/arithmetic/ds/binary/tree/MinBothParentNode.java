package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

/**
 * @Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 示例：
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * @Author: liuye
 * @time: 2020/8/27$ 下午10:29$
 */
public class MinBothParentNode {

    /**
     * 循环迭代方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else{
                break;
            }
        }
        return root;
    }

    /**
     * 递归方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left, p , q);
        }else if( root.val < p.val && root.val < q.val){
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }




}
