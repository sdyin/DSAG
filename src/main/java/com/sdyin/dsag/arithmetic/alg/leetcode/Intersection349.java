package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * @Author: liuye
 * @time: 2020/11/2$ 上午11:33$
 */
public class Intersection349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Map<Integer, Integer> map =  new HashMap<Integer,Integer>();
        for(int i = 0; i< nums1.length; i++){
            int data = nums1[i];
            if(!map.containsKey(data)){
                map.put(data, 1);
            }
        }


        for(int j =0; j<nums2.length; j++){
            int data = nums2[j];
            //没有else 防止nums2 多个 而nums1 没有场景
            if(map.containsKey(data)){
                map.put(data,map.get(data) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((k,v) ->{
            if(v <= 1){
                return;
            }
            list.add(k);
        });
        final int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
