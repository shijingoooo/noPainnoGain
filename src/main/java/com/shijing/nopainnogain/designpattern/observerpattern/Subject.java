package com.shijing.nopainnogain.designpattern.observerpattern;

/**
 * @Auther: shijing
 * @Date: 19/12/13 09:56
 * @Description:
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers(String msg);
}
