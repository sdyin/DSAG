package com.sdyin.dsag.arithmetic.other;

import java.lang.reflect.Method;

/**
 * @Description: ClassLoader 测试类
 * @Author: liuye
 * @time: 2020/9/17$ 下午9:20$
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        try {
            Class<?> class1 = ClassLoader.getSystemClassLoader().loadClass("com.sdyin.dsag.arithmetic.other.ClassLoaderTest");
            Class<?> class2 = ClassLoader.getSystemClassLoader().loadClass("com.sdyin.dsag.arithmetic.other.ClassLoaderTest");

            Object o1 = class1.newInstance();
            Object o2 = class2.newInstance();
            System.out.println("o1:" + o1);
            System.out.println("o2:" + o2);

            Method method = class1.getMethod("test", java.lang.String.class);
            //invoke方法返回值为 对应调用方法的返回值
            Object result = method.invoke(o1,"111");
            Object result2 = method.invoke(o2,"222");
            System.out.println("result:" + result + "," + "result2:" + result2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test(String s) {
        System.out.println(this + " 执行test方法," + s);
    }
}
