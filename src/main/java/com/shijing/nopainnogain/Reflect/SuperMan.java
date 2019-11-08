package com.shijing.nopainnogain.Reflect;

/**
 * @Auther: shijing
 * @Date: 19/5/11 16:12
 * @Description:
 */
class SuperMan extends Person implements ActionInterface {
    private boolean BlueBriefs;

    public void fly()
    {
        System.out.println("超人会飞耶～～");
    }

    public boolean isBlueBriefs() {
        return BlueBriefs;
    }
    public void setBlueBriefs(boolean blueBriefs) {
        BlueBriefs = blueBriefs;
    }

    @Override
    public void walk(int m, int n) {
        // TODO Auto-generated method stub
        System.out.println("超人会走耶～～走了" + (m + n) + "米就走不动了！");
    }
}
