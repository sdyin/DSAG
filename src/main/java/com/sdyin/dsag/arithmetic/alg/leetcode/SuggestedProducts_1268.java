package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1268. 搜索推荐系统
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。
 * 如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 * @Author: liuye
 * @time: 2023/11/7$ 11:33 上午$
 */
public class SuggestedProducts_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        // 对产品进行字典排序
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> suggestions = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                }
                if (suggestions.size() == 3) {
                    break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }
}
