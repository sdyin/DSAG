package com.sdyin.dsag.arithmetic.alg.dp;

/**
 * @Description 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * @Author liuye
 * @Date 2020/7/29 19:45
 **/
public class DecodeMethodTotal {

    public static int numDecodings(String str) {

        char[] s = str.toCharArray();
        //当第一位为0时，无法转义,0种
        if (s[0] == '0') {
            return 0;
        }
        //第一位一定为1种
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length; i++) {
            int tmp = curr;
            if (s[i] == '0') {
                //如果后一位为0时,前一位为1或2, 当前位与前一位种数相同
                //如果后一位为0时，前一位不为1或2，则为0种，比如xxx30,xxx50
                if (s[i - 1] == '1' || s[i - 1] == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')) {
                //小于26，则 f(n) = f(n - 1) + f(n - 2)
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int i = numDecodings("1234");
        System.out.println(i);
    }
}

