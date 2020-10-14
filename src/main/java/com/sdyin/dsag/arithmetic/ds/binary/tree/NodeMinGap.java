package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;
import org.checkerframework.checker.units.qual.min;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 530. 二叉搜索树的最小绝对差
 * @Author liuye
 * @Date 2020/10/12 11:11
 **/
public class NodeMinGap {

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        addVal(list, root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int value = list.get(i + 1) - list.get(i);
            min = value < min ? value : min;

        }
        return min;
    }

    /**
     * 二叉搜索树中序遍历可保证有序
     *
     * @param list
     * @param root
     */
    private void addVal(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        addVal(list, root.left);
        list.add(root.val);
        addVal(list, root.right);
    }
}
