package com.shijing.nopainnogain.designpattern.builderpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-05 19:39
 **/
// 指挥者，这里去指定
public class HouseDirector {
    private HouseBuilder houseBuilder;

    // 构造器传入 houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 通过setter 传入 houseBuilder

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }

}
