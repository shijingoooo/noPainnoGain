package com.shijing.nopainnogain.designpattern.proxy.dynamic;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-09 22:02
 **/
public class TeacherDao implements ITeacherDao{


    @Override
    public void teach() {
        System.out.println("老师授课中...");
    }
}
