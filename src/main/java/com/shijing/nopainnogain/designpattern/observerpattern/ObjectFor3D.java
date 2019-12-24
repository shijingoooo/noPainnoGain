package com.shijing.nopainnogain.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ObjectFor3D implements Subject {

    List<Observer> observerList = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer o : observerList) {
            o.update(msg);
        }
    }
}
