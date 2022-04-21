package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/21$ 6:01 下午$
 */
public class CanPartitionKSubsets698 {

    /**
     * 思路：n个数字的数组划分为 k个非空子集
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        //k个子集，每个子集的元素之和
        int target = sum / k;

        //k个桶，每个元素都存储当前桶装入的元素之和
        int[] bucket = new int[k];
        final boolean boo = backtrack(nums, 0, target, bucket);
        return boo;
    }

    private boolean backtrack(int[] nums, int index, int target, int[] bucket) {

        //边界条件. 遍历到最后一个元素时
        if (index == nums.length) {
            for (int b : bucket) {
                if (b != target) {
                    return false;
                }
            }
            //均满足，响应true
            return true;
        }

        //遍历每个桶, index的元素存放到每个桶尝试
        //n个元素放入k个桶，这里可以理解为以元素数字的视角，n个桶选择放入哪一个桶
        for (int i = 0; i < bucket.length; i++) {
            //边界条件，如果当前index索引元素放入第i个桶，大于目标值了，说明不匹配，跳过
            //其实就是剪枝(过滤)
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            //放入元素
            bucket[i] = bucket[i] + nums[index];

            //继续递归放入下一个元素
            //这里第二个参数是 index + 1 而不是 i+1 因为只会遍历一遍所有节点。
            if (backtrack(nums, index + 1, target, bucket)) {
                return true;
            }

            //撤销选择元素
            bucket[i] = bucket[i] - nums[index];

        }

        //所有节点都不匹配，则响应false
        return false;
    }


    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        //k个子集，每个子集的元素之和
        int target = sum / k;

        //k个桶，每个元素都存储当前桶装入的元素之和
        int[] bucket = new int[k];
        //回溯里使用移位运算符优化
        int used = 0;

        final boolean b = backtrack2(nums, 0, k, 0, used, target);
        return b;
    }

    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    /**
     * 回溯:
     *
     * @param nums      原数组
     * @param index     遍历到的下标索引
     * @param k         剩余k个子集
     * @param bucketSum 当前子集元素的和
     * @param used      每个字节记录当前索引处是否有使用
     * @param target    每个子集的元素目标和
     * @return
     */
    private boolean backtrack2(int[] nums, int index, int k, int bucketSum, int used, int target) {
        // 表示所有子集都组合了,满足匹配
        if (k == 0) {
            return true;
        }

        //当前bucket已符合，继续遍历下一个子集
        //下一个子集又是从索引 0处开始选择元素
        if (bucketSum == target) {
            final boolean b = backtrack2(nums, 0, k - 1, 0, used, target);
            //缓存当前结果
            map.put(used, b);
            return b;
        }

        //如果计算过，则直接获取缓存结果
        if (map.containsKey(used)) {
            return map.get(used);
        }

        //n个元素放入k个桶，这里可以理解为以桶的视角，k个元素选择放入哪个元素
        for (int i = index; i < nums.length; i++) {
            //过滤：第i位使用过，则跳过
            //右移i位，如果右移i位 后与上1 结果等于1，说明第i位是1
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (bucketSum + nums[i] > target) {
                continue;
            }

            //添加当前节点
            bucketSum += nums[i];
            //左移i位 将第i 位为1,然后再和原used做 或运算，效果就是把第i位换成1
            used = used | (1 << i);


            //回溯,继续放下一个索引下标的元素
            if (backtrack2(nums, i + 1, k, bucketSum, used, target)) {
                return true;
            }

            //撤销选择节点
            bucketSum -= nums[i];
            //异或操作：相同为假,不同为真。即原来第i位是1就变成0,原来第i位为0 仍然保持为0
            used = used ^ (1 << i);
        }
        return false;
    }
}
