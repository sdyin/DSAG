package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/9/15$ 2:21 下午$
 */
public class RecoverTree99 {

    //普通解法： 中序遍历，将节点保存在集合中，交换顺序关系不满足的两个节点
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);

        TreeNode x = null;
        TreeNode y = null;

        //扫描遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                //第一次给x赋值，后续每次依次循环给y赋值，直到满足
                if (x == null) {
                    x = list.get(i);
                }
            }
        }

        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }

    }

    //中序遍历二叉树，并将遍历的结果保存到list中
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }


}
