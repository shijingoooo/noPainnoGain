package com.shijing.nopainnogain.designpattern.builderpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-05 19:37
 **/
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼的地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼的砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼盖透明屋顶");
    }
}
