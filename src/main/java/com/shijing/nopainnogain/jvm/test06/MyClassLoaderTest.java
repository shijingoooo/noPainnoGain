package com.shijing.nopainnogain.jvm.test06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: shijing
 * @Date: 19/4/23 17 41
 * @Description:
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException
            , IllegalAccessException, InstantiationException
            , NoSuchMethodException, InvocationTargetException {
        //方式一
        //MyClassLoader myClassLoader = new MyClassLoader();

        //方式二
        ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader();
        MyClassLoader myClassLoader = new MyClassLoader("E:\\my\\jvmDemo\\src", null);
        Class<?> aClass = myClassLoader.loadClass("com.shijing.test06.HelloWorld");

        System.out.println(aClass.getClassLoader());

        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String) welcomeMethod.invoke(helloWorld);
        System.out.println("Result:" +result);
    }
}
