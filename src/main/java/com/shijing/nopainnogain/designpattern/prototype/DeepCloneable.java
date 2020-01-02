package com.shijing.nopainnogain.designpattern.prototype;

import java.io.*;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-02 22:46
 **/
public class DeepCloneable implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneable(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // 因为该类的属性都是String，因此我们这里使用默认的clone完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "DeepCloneable{" +
                "cloneName='" + cloneName + '\'' +
                ", cloneClass='" + cloneClass + '\'' +
                '}';
    }
}
