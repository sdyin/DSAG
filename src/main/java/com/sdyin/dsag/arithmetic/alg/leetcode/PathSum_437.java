package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description: 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @Author: liuye
 * @time: 2023/9/10$ 3:24 下午$
 */
public class PathSum_437 {

    int count = 0;

    /**
     * bfs + dfs 解法, 测试用例可能有整形溢出问题，超出了int 边界
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return count;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 以每个节点为根节点进行遍历匹配
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            sum(node, targetSum, 0);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return count;
    }

    /**
     * 递归匹配
     *
     * @param node
     * @param targetSum
     * @param currentSum
     */
    private void sum(TreeNode node, int targetSum, int currentSum) {
        if (node.val + currentSum == targetSum) {
            count++;
        }
        if (node.left != null) {
            sum(node.left, targetSum, node.val + currentSum);
        }
        if (node.right != null) {
            sum(node.right, targetSum, node.val + currentSum);
        }
    }

    public static void main(String[] args) {
        PathSum_437 pathSumObj = new PathSum_437();

        Integer[] nums = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode root = new TreeNode(1000000000);

        TreeNode left_2 = new TreeNode(1000000000);
        root.left = left_2;

        TreeNode left_3 = new TreeNode(294967296);
        left_2.left = left_3;

        TreeNode left_4 = new TreeNode(1000000000);
        left_3.left = left_4;

        TreeNode left_5 = new TreeNode(1000000000);
        left_4.left = left_5;

        TreeNode left_6 = new TreeNode(1000000000);
        left_5.left = left_6;

        int size = pathSumObj.pathSum(root, 0);
        System.out.println(size);
    }

    /**
     * 构造树
     * @param nums
     * @return
     */
    public TreeNode constructTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0);
    }

    private TreeNode buildTree(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(nums[index]);
        if (2 * index + 1 < nums.length) {
            node.left = buildTree(nums, 2 * index + 1);
        }
        if (2 * index + 2 < nums.length) {
            node.right = buildTree(nums, 2 * index + 2);
        }

        return node;
    }

    // 哈希表，用于存储前缀和及其出现的次数。键是前缀和，值是该前缀和出现的次数。
    Map<Long, Long> preSum = new HashMap<>();

    /**
     * 前缀和解法
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        preSum.put(0L, 1L);
        return (int)dfs(root, 0, sum);
    }

    private long dfs(TreeNode root, long currSum, int target) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        long res = preSum.getOrDefault(currSum - target, 0L);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0L) + 1);

        res += dfs(root.left, currSum, target) + dfs(root.right, currSum, target);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
