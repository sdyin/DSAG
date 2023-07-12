package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 380. O(1) 时间插入、删除和获取随机元素
 *
 * @Author: liuye
 * @time: 2023/7/11$ 5:28 下午$
 */
public class RandomizedSet_380_2 {

    // 集合存储元素的值
    private List<Integer> nums;

    // map: key->元素值, value->下标索引
    private Map<Integer, Integer> valToIndex;


    public RandomizedSet_380_2() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    // 添加元素
    public boolean insert(int val) {
        // 如果存在元素, 返回false
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 不存在元素, 添加到集合尾部
        nums.add(val);
        // 更新map
        valToIndex.put(val, nums.size() - 1);
        return true;
    }

    // 移除元素
    public boolean remove(int val) {
        // 不存在元素, 返回false
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // 存在元素, 获取元素下标
        int index = valToIndex.get(val);
        // 获取集合尾部元素
        int lastVal = nums.get(nums.size() - 1);
        // 更新尾部元素的下标索引(移动到要删除元素index位置)
        valToIndex.put(lastVal, index);
        nums.set(index, lastVal);

        // 删除最后一个元素
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    // 获取随机元素
    public int getRandom() {
        Integer value = nums.get((int) (Math.random() * nums.size()));
        return value;
    }

}
