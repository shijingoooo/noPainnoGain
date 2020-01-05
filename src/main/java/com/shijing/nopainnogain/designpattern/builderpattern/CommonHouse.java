package com.shijing.nopainnogain.designpattern.builderpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-05 19:31
 **/
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子打砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子盖屋顶");
    }
}
