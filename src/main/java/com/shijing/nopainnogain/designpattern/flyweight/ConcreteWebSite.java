package com.shijing.nopainnogain.designpattern.flyweight;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-07 22:19
 **/
public class ConcreteWebSite extends WebSite {

    private String type = ""; // 网站发布的形式（类型）

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为：" + type + "使用者是：" + user.getName());

    }
}
