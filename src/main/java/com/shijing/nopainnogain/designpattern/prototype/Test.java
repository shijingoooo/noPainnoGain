package com.shijing.nopainnogain.designpattern.prototype;

import java.io.*;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-02 22:12
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        Sheep sheep = new Sheep("tom", 1, "白色");
        sheep.friend = new Sheep("jack", 2, "黑色");

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println("sheep1: " + sheep1 + "sheep1.friend: " + sheep1.friend.hashCode());
        System.out.println("sheep2: " + sheep2 + "sheep2.friend: " + sheep2.friend.hashCode());


        // 深拷贝
        System.out.println("深拷贝一");
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "张三";
        deepProtoType.deepCloneable = new DeepCloneable("李四", "李四的类");

        DeepProtoType copy1 = (DeepProtoType) deepProtoType.clone();

        System.out.println(deepProtoType.name);
        System.out.println(deepProtoType.deepCloneable.hashCode());
        System.out.println("==================");
        System.out.println(copy1.name);
        System.out.println(copy1.deepCloneable.hashCode());

        System.out.println("深拷贝二");
        DeepProtoType deepProtoType2 = new DeepProtoType();
        deepProtoType2.name = "张三";
        deepProtoType2.deepCloneable = new DeepCloneable("李四", "李四的类");
        DeepProtoType copy2 = (DeepProtoType) deepProtoType2.deepClone();

        System.out.println(deepProtoType.name);
        System.out.println(deepProtoType.deepCloneable.toString());
        System.out.println(deepProtoType.deepCloneable.hashCode());
        System.out.println("==================");
        System.out.println(copy2.name);
        System.out.println(copy2.deepCloneable.hashCode());
        System.out.println(copy2.deepCloneable.toString());
    }


}
