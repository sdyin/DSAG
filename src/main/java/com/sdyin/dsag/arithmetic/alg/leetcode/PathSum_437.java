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

    /**
     * bfs + dfs 解法
     * 时间复杂度：O(n²)，空间复杂度：O(n)
     * bfs 遍历每个节点，dfs 计算以当前节点为起点的路径数, 总访问次数 = N + (N-1) + (N-2) + ... + 1 = N(N+1)/2 = O(N²)
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int totalCount = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 以每个节点为根节点进行遍历匹配
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 计算以当前节点为起点的路径数
            totalCount += countPathsFromRoot(node, targetSum, 0L);;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return totalCount;
    }

    /**
     * 递归匹配
     *
     * @param node
     * @param targetSum
     * @param currentSum
     * @return int
     */
    private int countPathsFromRoot(TreeNode node, int targetSum, long currentSum) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        currentSum += node.val;

        // 检查当前路径是否满足条件
        if (currentSum == targetSum) {
            count++;
        }

        // 继续向下搜索
        count += countPathsFromRoot(node.left, targetSum, currentSum);
        count += countPathsFromRoot(node.right, targetSum, currentSum);

        return count;
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
     * 前缀和 + 哈希表优化解法
     * 时间复杂度：O(n)，空间复杂度：O(n)
     *
     * 前缀和解法每个节点只访问一次：
     * 一次 DFS 遍历整棵树
     * 每个节点处理时间为 O(1)（哈希表查找）
     * 总时间复杂度 = O(N)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        // 前缀和为0的情况出现1次（空路径）
        preSum.put(0L, 1L);
        return (int)dfs(root, 0, sum);
    }

    private long dfs(TreeNode root, long currSum, int target) {
        if (root == null) {
            return 0;
        }
        // 更新当前路径和
        currSum += root.val;

        // 检查是否存在前缀和，使得 currentSum - prefixSum = target
        long res = preSum.getOrDefault(currSum - target, 0L);
        // 将当前前缀和加入map
        preSum.put(currSum, preSum.getOrDefault(currSum, 0L) + 1);

        // 递归处理左右子树
        res += dfs(root.left, currSum, target) + dfs(root.right, currSum, target);
        // 回溯：移除当前节点的前缀和（重要！）
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
