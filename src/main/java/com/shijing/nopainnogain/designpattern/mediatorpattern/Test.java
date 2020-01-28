package com.shijing.nopainnogain.designpattern.mediatorpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-15 21:33
 **/
public class Test {
    public static void main(String[] args) {
        // 创建一个中介者对象
        Mediator mediator = new ConcreteMediator();

        // 创建Alarm 并且加入到 ConcreteMediator 对象的HashMap
        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tv = new TV(mediator, "TV");
        alarm.sendAlarm(0);
        coffeeMachine.FinishCoffee();
        alarm.sendAlarm(1);
    }
}
