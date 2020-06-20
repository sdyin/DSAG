package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 验证回文: leetcode-125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @Author liuye
 * @Date 2020/6/19 9:26
 **/
public class VerifyPalindrome {

    public boolean isPalindrome(String s) {

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                buffer.append(Character.toLowerCase(c));
            }
        }
        int n = buffer.length();
        int left = 0;
        int right = buffer.length() - 1;

        while (left < right){
            if(Character.toLowerCase(buffer.charAt(left)) != Character.toLowerCase(buffer.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPalindrome verifyPalindrome = new VerifyPalindrome();
        String s = "abcba";
        boolean boo = verifyPalindrome.isPalindrome(s);
        System.out.println("是否回文:" + boo);
    }
}
