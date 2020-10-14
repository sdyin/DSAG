package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description 1002.查找常用字符
 * //给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
 * //是 4 次，则需要在最终答案中包含该字符 3 次。
 * //
 * // 你可以按任意顺序返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：["bella","label","roller"]
 * //输出：["e","l","l"]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：["cool","lock","cook"]
 * //输出：["c","o"]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= A.length <= 100
 * // 1 <= A[i].length <= 100
 * // A[i][j] 是小写字母
 * //
 * // Related Topics 数组 哈希表
 * // 👍 152 👎 0
 * @Author liuye
 * @Date 2020/10/14 16:47
 **/
public class FindChar1002 {

    /**
     * 我们可以使用 minfreq[c] 存储字符 cc 在所有字符串中出现次数的最小值
     *
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        int[] acs = getCs(A[0]);

        for (int i = 1; i < A.length; i++) {
            int[] aics = getCs(A[i]);

            for (int j = 0; j < acs.length; j++) {
                if (acs[j] > aics[j]) {
                    //取最小的次数
                    acs[j] = aics[j];
                }
            }
        }

        List<String> list = new LinkedList<>();
        for (int i = 0; i < acs.length; i++) {
            //转成字符
            String e = Character.toString((char) ('a' + i));

            //出现多次则添加多次
            while (acs[i]-- > 0) {
                list.add(e);
            }
        }

        return list;
    }

    private static int[] getCs(String s) {
        int[] cs = new int[26];

        //如果有该字符，则该字符对应下标索引处值加一
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }

        return cs;
    }


    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        List<String> list = commonChars(A);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
