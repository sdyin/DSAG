package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *
 *
 * 示例1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/1/5$ 下午10:18$
 */
public class LargeGroupPositions830 {

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if(s.length() == 0){
            return list;
        }
        int sum = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.codePointAt(i) == s.codePointAt(i-1) && s.length() != (i+1)){
                sum++;
            }else{
                if(s.codePointAt(i) == s.codePointAt(i-1) && s.length() == (i+1)){
                    sum++;
                    //此时i++ 是为了满足最后一位相当于增加了一个虚拟尾节点，防止最后一位sum自增 i节点没增长导致的位数不匹配
                    i++;
                }
                if(sum >= 3){
                    final List<Integer> list1 = new ArrayList<>();
                    list1.add((i - 1) - (sum - 1));
                    list1.add(i - 1);
                    list.add(list1);
                    sum = 1;
                }else {
                    sum = 1;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //String s = "babaaaabbb";
        String s = "aaa";
        final List<List<Integer>> lists = largeGroupPositions(s);
        System.out.println(lists);
    }
}
