package com.shijing.nopainnogain.designpattern.responsibilitychain;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-19 21:29
 **/
public class PurchaseRequest {
    private int type;
    private float price = 0.0F;
    private int id;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
