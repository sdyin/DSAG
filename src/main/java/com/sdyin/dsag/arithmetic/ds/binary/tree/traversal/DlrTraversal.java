package com.sdyin.dsag.arithmetic.ds.binary.tree.traversal;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 前序遍历
 * 对于当前节点，先输出该节点，然后输出他的左孩子，最后输出他的右孩子
 * 参考网址：https://mp.weixin.qq.com/s/yWY0JgB1-XqIVgSFInBXeQ
 * @Author: liuye
 * @time: 2020/8/18$ 下午10:53$
 */
public class DlrTraversal {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        list = serialize(list, root);
        String result = list.stream().collect(Collectors.joining(","));
        return result;
    }

    private List<String> serialize(List<String> list, TreeNode root) {
        if(root == null){
            list.add("#");
            return list;
        }
        list.add(root.val + "");

        serialize(list, root.left);
        serialize(list, root.right);
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            linkedList.add(list.get(i));
        }
        TreeNode treeNode = deserialize(linkedList);
        return treeNode;
    }

    private TreeNode deserialize(LinkedList<String> linkedList) {
        if(linkedList == null){
            return null;
        }
        String s = linkedList.removeFirst();
        if(s.equals("#")){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = deserialize(linkedList);
        treeNode.right = deserialize(linkedList);
        return treeNode;
    }
}
