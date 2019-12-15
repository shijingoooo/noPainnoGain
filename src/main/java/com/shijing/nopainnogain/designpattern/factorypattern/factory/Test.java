package com.shijing.nopainnogain.designpattern.factorypattern.factory;

/**
 * 工厂方法模式是简单工厂的仅一步深化， 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的对象，
 * 而是针对不同的对象提供不同的工厂。也就是说每个对象都有一个与之对应的工厂。
 *
 * 定义：
 * 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 *
 * 通过这个实例各位小伙伴是不是对工厂模式有了进一步的理解呢，和简单工厂对比一下，最根本的区别在于，
 * 简单工厂只有一个统一的工厂类，而工厂方法是针对每个要创建的对象都会提供一个工厂类，
 * 这些工厂类都实现了一个工厂基类（本例中的ReaderFactory ）。下面总结一下工厂方法的适用场景。
 *
 * 适用场景：
 *（1）客户端不需要知道它所创建的对象的类。例子中我们不知道每个图片加载器具体叫什么名，
 * 只知道创建它的工厂名就完成了床架过程。
 *（2）客户端可以通过子类来指定创建对应的对象。
 * 以上场景使用于采用工厂方法模式。
 */
public class Test {
    public static void main(String[] args) {
        ReaderFactory factory = new JpgReaderFactory();
        Reader reader = factory.getReader();
        reader.read();

        factory = new PngReaderFactory();
        reader = factory.getReader();
        reader.read();

        factory = new GifReaderFactory();
        reader = factory.getReader();
        reader.read();

    }
}
