package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2020/12/23$ 下午8:30$
 */
public class FirstUniqChar387 {

    public static int firstUniqChar(String s) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i< s.length(); i++){
            String value = String.valueOf(s.charAt(i));
            if(map.containsKey(value)){
                map.put(value, -1);
            }else{
                map.put(value, i);
            }
        }

        //此处不能用map的长度遍历，有可能漏掉后面几位字符串
        for (int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));
            System.out.println(value);
            if(map.get(value) != -1){
                return map.get(value);
            }
        }
        //注意： 用lambda表达式 map 会无序！！！
        /*map.forEach((k,v) -> {
            System.out.println(k);
        });*/
        return -1;
    }

    public static void main(String[] args) {
        String s = "dddccdbba";
        final int i = firstUniqChar(s);
        System.out.println(i);
    }


}
