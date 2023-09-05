package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * @Author: liuye
 * @time: 2023/9/5$ 11:45 上午$
 */
public class UniqueOccurrences_1207 {

    public static boolean uniqueOccurrences(int[] arr) {
        //key-value 存放元素及出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //key 保存元素出现次数
        Map<Integer, Integer> mapKeySize = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((k,v) -> {
            if (mapKeySize.containsKey(v)) {
                list.add(v);
            }
            mapKeySize.put(v, 1);
        });
        return list.size() > 0 ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        boolean b = uniqueOccurrences(arr);
        System.out.println(b);
    }
}
