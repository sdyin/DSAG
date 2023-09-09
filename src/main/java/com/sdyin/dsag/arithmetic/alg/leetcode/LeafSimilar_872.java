package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 872. 叶子相似的树
 * @Author: liuye
 * @time: 2023/9/9$ 7:51 下午$
 */
public class LeafSimilar_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaf(root1);
        List<Integer> list2 = getLeaf(root2);
        String s1 = list1.stream().map(String::valueOf).collect(Collectors.joining("-"));
        String s2 = list2.stream().map(String::valueOf).collect(Collectors.joining("-"));
        return s1.equals(s2);
    }

    private List<Integer> getLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addNode(root, list);
        return list;
    }

    /**
     * 递归组装叶子节点
     *
     * @param root
     * @param list
     */
    private void addNode(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            addNode(root.left, list);
        }
        if (root.right != null) {
            addNode(root.right, list);
        }
    }
}
