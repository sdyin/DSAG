package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode: 5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Author: liuye
 * @time: 2022/1/24$ 9:27 下午$
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        String s = "bb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //因为最少会有2个字符长度，所以肯定最小长度为1
        int maxLen = 1;
        int begin = 0;
        //长度大于等于2开始判断
        for (int l = 2; l <= len; l++) {
            //左边界开始
            for (int i = 0; i < len; i++) {
                // 确定右边界值,下标索引，所以减一
                int j = l + i - 1;

                //右边界越界，就退出当前循环
                if (j >= len) {
                    break;
                }

                //i,j 不相等时,区间[i,j] 肯定不是回文
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 区间长度小于3, i，j 下标值相等即肯定是回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //[i,j] 相等，那就取决于[i+1, j-1]是不是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    //长度等于下标索引值+1
                    maxLen = j - i + 1;
                    //记录起始值
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 双指针法求解
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i+1;
            //单个字符作为回文中心字符
            String s1 = findLongestPalindrome(s, left, left);
            //两个字符作为回文中心字符
            String s2 = findLongestPalindrome(s, left, right);
            String max = s1.length() > s2.length() ? s1 : s2;
            result = max.length() > result.length() ? max : result;
        }
        return result;
    }


    private static String findLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 双指针向两侧展开
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left + 1, right);
    }
}
