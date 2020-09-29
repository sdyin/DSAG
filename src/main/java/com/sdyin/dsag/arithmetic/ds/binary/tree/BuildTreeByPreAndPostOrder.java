package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

/**
 * @Description 106.根据一棵树的中序遍历与后序遍历构造二叉树。
 * // 注意:
 * //你可以假设树中没有重复的元素。
 * //
 * // 例如，给出
 * //
 * // 中序遍历 inorder = [9,3,15,20,7]
 * //后序遍历 postorder = [9,15,7,20,3]
 * //
 * // 返回如下的二叉树：
 * //
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * //
 * // Related Topics 树 深度优先搜索 数组
 * // 👍 379 👎 0
 * @Author liuye
 * @Date 2020/9/29 11:25
 **/
public class BuildTreeByPreAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd){
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode rootNode = new TreeNode(rootVal);
        int index = 0;
        //inEnd是下标索引，所以这里是<= 而不是 <
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        //左子树节点数量
        //可以思考下这里为什么 leftSize = index; 不行，从上下文看 inStart不是一直等于0吗
        //答: 这里inStart 不是一直等于0,在递归中，如果当前是右子树，则不是从0开始了
        int leftSize = index - inStart;
        System.out.println("inStart:" + inStart);
        rootNode.left = buildTree(inorder, inStart, index-1, postorder, postStart, postStart + leftSize -1);
        rootNode.right = buildTree(inorder, index+1, inEnd, postorder, postStart + leftSize,postEnd - 1);
        return rootNode;
    }
}
