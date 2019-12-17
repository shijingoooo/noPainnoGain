package com.shijing.nopainnogain.designpattern.facadepattern;

public class Water {
    private int temperature;    // 温度
    private int capacity;       // 容量
    public Water() {
        this.temperature = 0;
        this.capacity = 10;
    }

    public Water(int temperature, int capacity) {
        this.temperature = temperature;
        this.capacity = capacity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

