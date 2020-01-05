package com.shijing.nopainnogain.designpattern.builderpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-05 19:45
 **/
public class Test {
    public static void main(String[] args) {
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        // 完成盖房子，返回产品（房子）
        House house = houseDirector.constructHouse();

        System.out.println("================");
        HighBuilding highBuilding = new HighBuilding();
        houseDirector.setHouseBuilder(highBuilding);
        House house1 = houseDirector.constructHouse();

        StringBuilder stringBuilder = new StringBuilder();

        /**
         * JDK源码中建造者模式角色分析
         * Appendable 接口定义了多个append方法（抽象方法），即Appendable为抽象建造者，定义了抽象方法
         * AbstractStringBuilder 实现了Appendable 接口方法，这里的 AbstractStringBuilder 已经是建造者，只是不能实例化
         * StringBuilder 即充当了指挥者角色，同时充当了具体的建造者，建造方法的实现是由AbstractStringBuilder完成，而StringBuilder
         * 继承了AbstractStringBuilder
         *
         */

    }
}
