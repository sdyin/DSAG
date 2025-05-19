package com.sdyin.dsag.arithmetic.ds.binary;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/8/18$ 下午11:08$
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
