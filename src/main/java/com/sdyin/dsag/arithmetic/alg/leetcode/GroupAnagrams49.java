package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @Author: liuye
 * @time: 2025/5/8$ 10:38$
 */
public class GroupAnagrams49 {

    /**
     * 常规解题方式
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 排序后作为key
            Arrays.sort(chars);
            String key = new String(chars);
            // 更优雅的方式
            // map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 计数法：
     * 由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，
     * 可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     *
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 26 的数组记录每个字母出现的次数。
     * 需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     * 需要遍历 n 个字符串，对于每个字符串，需要 O(k)的时间计算字符串中的每个字母的出现次数，
     * 时间复杂度是 O(nk)。
     *
     * 空间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     * 需要用哈希表存储全部字符串，而记录每个字符串中每个字母出现次数的数组需要的空间为 O(k)，
     * 在渐进意义下小于 O(nk)，忽略常数项可以得到总时间复杂度 O(nk)。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 创建一个26位的数组来统计每个字母的出现次数
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                // 将字符转换为0-25的索引， 出现次数+1
                count[c - 'a']++;
            }
            // 将计数数组转换为字符串作为键
            String key = Arrays.toString(count);

            // 如果键不存在则创建新列表
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
