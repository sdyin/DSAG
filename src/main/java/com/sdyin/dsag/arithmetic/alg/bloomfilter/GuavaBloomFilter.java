package com.sdyin.dsag.arithmetic.alg.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Description guava提供的布隆过滤器
 * 缺点是只能单机使用,数据放在本地内存
 * @Author liuye
 * @Date 2020/8/27 11:03
 **/
public class GuavaBloomFilter {

    public static void main(String[] args) {
        //Funnels.stringFunnel(Charsets.UTF_8);
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 5000, 0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
