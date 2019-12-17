package com.shijing.nopainnogain.designpattern.facadepattern;

public class TeasetService {
    public TeaWater makeTeaWater(String who, Water water, TeaLeaf teaLeaf) {
        String teaWater = "一杯容量为 " + water.getCapacity() + ", 温度为 " + water.getTemperature()
                + " 的" + teaLeaf.getTeaName() + "茶水";
        System.out.println(who + " 泡了" + teaWater);
        return new TeaWater(teaWater);
    }
}

