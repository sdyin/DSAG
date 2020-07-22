package com.sdyin.dsag.arithmetic.alg;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/6/29$ 下午9:55$
 */
public class Test {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);//输出结果是父类中的静态变量值A，也就是2
    }
}
