package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 381. O(1) 时间插入，删除，获取随机元素
 * //设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * //
 * // 注意: 允许出现重复元素。
 * //
 * //
 * // insert(val)：向集合中插入元素 val。
 * // remove(val)：当 val 存在时，从集合中移除一个 val。
 * // getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * //
 * //
 * // 示例:
 * //
 * // // 初始化一个空的集合。
 * //RandomizedCollection collection = new RandomizedCollection();
 * //
 * //// 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * //collection.insert(1);
 * //
 * //// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * //collection.insert(1);
 * //
 * //// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * //collection.insert(2);
 * //
 * //// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * //collection.getRandom();
 * //
 * //// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * //collection.remove(1);
 * //
 * //// getRandom 应有相同概率返回 1 和 2 。
 * //collection.getRandom();
 * //
 * // Related Topics 设计 数组 哈希表
 * // 👍 170 👎 0
 * @Author: liuye
 * @time: 2020/11/1$ 上午11:54$
 */
public class RandomizedCollection381 {

    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection381() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

}
