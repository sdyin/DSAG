package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 380. O(1) 时间插入、删除和获取随机元素
 * @Author: liuye
 * @time: 2022/4/12$ 5:07 下午$
 */
public class RandomizedSet380 {
    List<Integer> numList;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet380() {
        numList = new ArrayList<Integer>();
        indices = new HashMap<>();
        random = new Random();
    }

    /**
     * 添加元素, 数组中添加元素，map存放元素及对应的索引位置
     *
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        final int size = numList.size();
        indices.put(val, size);
        numList.add(val);
        return true;
    }

    /**
     * 移除元素 -> 把要移除的元素放到末尾。
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        //元素的下标索引
        final Integer index = indices.get(val);
        final Integer lastValue = numList.get(numList.size() - 1);
        //把val 元素所在索引的元素更新为最后一个元素的值
        numList.set(index, lastValue);
        indices.put(lastValue, index);
        //移除数组元素
        numList.remove(numList.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        final int index = random.nextInt(numList.size());
        return numList.get(index);
    }
}
