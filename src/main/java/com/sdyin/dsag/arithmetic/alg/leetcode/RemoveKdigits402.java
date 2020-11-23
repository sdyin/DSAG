package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Stack;

/**
 * @Description: 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2020/11/15$ 下午5:28$
 */
public class RemoveKdigits402 {

    public String removeKdigits(String num, int k) {
        //特殊情况全部删除
        if (num.length() == k) {
            return "0";
        }
        char[] s = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        //遍历数组
        for (Character i : s) {
            //移除元素的情况，k--
            while (!stack.isEmpty() && i < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            //栈为空，且当前位为0时，我们不需要将其入栈
            if (stack.isEmpty() && i == '0') {
                continue;
            }
            stack.push(i);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        //这个是最后栈为空时，删除一位，比如我们的10，删除一位为0，按上面逻辑我们会返回""，所以我们让其返回"0"
        if (stack.isEmpty()) {
            return "0";
        }
        //反转并返回字符串
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }

}
