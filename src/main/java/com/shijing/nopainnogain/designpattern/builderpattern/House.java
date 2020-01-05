package com.shijing.nopainnogain.designpattern.builderpattern;

/**
 * @description: 产品 Product
 * @author: shijing
 * @create: 2020-01-05 19:25
 **/
public class House {
    private String baise;

    private String wall;

    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
