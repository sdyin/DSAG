package com.sdyin.dsag.arithmetic.alg.leetcode;

import lombok.val;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Description 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Author liuye
 * @Date 2020/9/26 15:36
 **/
public class PathSum2 {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    /**
     * dfs 深度优先搜索
     * @param root
     * @param sum
     */
    private void dfs(TreeNode root, int sum) {
        if(root == null){
            return;
        }
        sum -= root.val;
        path.offerLast(root.val);
        if(root.left == null && root.right == null && 0 == sum){
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //删除该节点，即删除非叶子节点
        path.pollLast();
    }

    /**
     * bfs 广度优先搜素
     * 一行一行遍历
     * @param treeNode
     * @param sum
     */
    private List<List<Integer>> pathSumBfs(TreeNode root, int sum){

        List<List<Integer>> res = new ArrayList<>();
        //如果节点为空直接返回
        if (root == null){
            return res;
        }

        //使用两个队列，一个存储结点，一个存储从跟结点到当前节点的路径
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();

        //跟节点入队
        queueNode.add(root);
        //根节点的路径入队(每个元素为集合)
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queueList.add(list);

        while (!queueNode.isEmpty()) {
            //当前节点出队
            TreeNode node  = queueNode.poll();
            //当前节点的路径出队
            List<Integer> tempList = queueList.poll();

            //满足条件，添加路径到响应
            if(node.left == null && node.right == null && node.val == sum){
                res.add(tempList);
            }

            //左子节点不为空
            if(node.left != null){
                //路径入队
                tempList.add(node.left.val);
                queueList.add(new ArrayList<>(tempList));

                //节点累计路径和
                node.left.val += node.val;
                //节点入队
                queueNode.add(node.left);
                //删除左节点路径，左节点路径不能和右节点累加
                tempList.remove(tempList.size() - 1);

            }

            //右节点不为空
            if(node.right != null){
                //路径入队
                tempList.add(node.right.val);
                queueList.add(new ArrayList<>(tempList));

                //节点累计路径和
                node.right.val += node.val;
                //节点入队
                queueNode.add(node.right);
            }

        }

        return res;

    }



}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
