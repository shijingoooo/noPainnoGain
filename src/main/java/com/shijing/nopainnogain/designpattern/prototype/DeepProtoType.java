package com.shijing.nopainnogain.designpattern.prototype;

import java.io.*;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-02 22:50
 **/
public class DeepProtoType implements Serializable, Cloneable {
    public String name;

    public DeepCloneable deepCloneable; // 引用类型

    public DeepProtoType() {
        super();
    }

    // 深拷贝 - 方式一 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        // 这里完成对基本数据类型（属性）和String的克隆
        deep = super.clone();

        // 对引用类型的属性，进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneable = (DeepCloneable) deepCloneable.clone();

        return deepProtoType;
    }

    public Object deepClone() {
        // 创建流对象
        // ByteArrayOutputStream bos = null;
        // ObjectOutputStream oos = null;
        // ByteArrayInputStream bis = null;
        // ObjectInputStream ois = null;

        try (
                // 序列化
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(this);

            // 反序列化
            try (
                 ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)
            ) {
                return ois.readObject();
            } catch (Exception e) {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
