package com.shijing.nopainnogain.JVM.test06;

/**
 * @Auther: shijing
 * @Date: 19/4/23 17 21
 * @Description:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("---根类加载器---");
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("---------------");

        System.out.println("---扩展类加载器---");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("-----------------");

        System.out.println("---系统类加载器---");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println("-----------------");
    }
}
