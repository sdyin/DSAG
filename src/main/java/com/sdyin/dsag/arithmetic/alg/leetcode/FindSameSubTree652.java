package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 652.寻找重复的子树
 * //给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * //
 * // 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * //
 * // 示例 1：
 * //
 * //         1
 * //       / \
 * //      2   3
 * //     /   / \
 * //    4   2   4
 * //       /
 * //      4
 * //
 * //
 * // 下面是两个重复的子树：
 * //
 * //       2
 * //     /
 * //    4
 * //
 * //
 * // 和
 * //
 * //     4
 * //
 * //
 * // 因此，你需要以列表的形式返回上述重复子树的根结点。
 * // Related Topics 树
 * // 👍 165 👎 0
 * @Author liuye
 * @Date 2020/10/15 16:35
 **/
public class FindSameSubTree652 {

    //记录所有子树序列化后的值及其出现次数
    HashMap<String, Integer> map = new HashMap<>();

    //记录重复子树的节点
    LinkedList<TreeNode> list = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        return list;
    }

    /**
     * 序列化树-方便判断是否重复子树
     *
     * @param root
     * @return
     */
    public String traverse(TreeNode root) {
        if(root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right+ "," + root.val;

        if(map.containsKey(subTree)){
            //多个重复子树时,只添加一次
            if(map.get(subTree) == 1){
                list.add(root);
            }
            map.put(subTree, map.get(subTree) + 1);
        }else{
            map.put(subTree, 1);
        }
        return subTree;
    }
}
