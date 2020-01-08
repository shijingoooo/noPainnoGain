package com.shijing.nopainnogain.designpattern.flyweight;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-07 22:21
 **/
public class Test {
    public static void main(String[] args) {
        // 创建一个工厂类
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        // 客户要一个以新闻形式发布的网站
        WebSite webSite0 = webSiteFactory.getWebSiteCategory("新闻");
        webSite0.use(new User("Tome"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite1 = webSiteFactory.getWebSiteCategory("博客");
        webSite1.use(new User("Jack"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite2 = webSiteFactory.getWebSiteCategory("新闻");
        webSite2.use(new User("Smith"));
        // 网站的分类
        System.out.println("网站的分类：" + webSiteFactory.getWebSiteCount());

        System.out.println("=========================");

        /**
         * 如果Integer.value(x) x 在 -128 到 127 之间，就是使用享元模式返回
         * 如果不在范围内，则仍然 new Integer(x)
         */
        Integer x = Integer.valueOf(127);
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);

        System.out.println(x.equals(y));
        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(w == x);
        System.out.println(w == y);

        System.out.println("============================");
        Integer x1 = Integer.valueOf(128);
        Integer x2 = Integer.valueOf(128);
        System.out.println(x == y);
    }
}
